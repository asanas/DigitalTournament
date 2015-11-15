package com.digitour.app.controller.homepage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.City;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TeamSponsorsDetails;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.db.model.support.enums.TeamType;
import com.digitour.app.manager.CityManager;
import com.digitour.app.manager.PlayerProfileManager;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TeamSponsorsManager;
import com.digitour.app.manager.TournamentManager;
import com.digitour.app.manager.TournamentParticipantManager;
import com.digitour.app.manager.TournamentParticipantTeamManager;

@Controller
public class TeamController {

    private static final Log log = LogFactory.getLog(TeamController.class);
    
    @Autowired
    CityManager cityManager;
    
    @Autowired
    TeamManager teamManager;
    
    @Autowired
    PlayerProfileManager playerProfileManager;
    
    @Autowired
    TournamentManager tourManager;

    @Autowired
    TournamentParticipantManager tourParticipantManager;

    @Autowired
    TournamentParticipantTeamManager tourPartiTeamManager;

    @Autowired
    TeamSponsorsManager sponsorsManager;
    
    @RequestMapping(value="/import/team", method=RequestMethod.GET)
    public ModelAndView showImportTeamForm() {
        ModelAndView modelAndView = new ModelAndView("importexport/import-team");
        List<City> cityList = cityManager.getAllCities();
        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }

    @RequestMapping(value="/createnew/team", method=RequestMethod.POST)
    public ModelAndView createNewTeam(@RequestParam String teamName, @RequestParam String displayName, @RequestParam String founderName, @RequestParam String description,
            @RequestParam String address, @RequestParam String achievements, @RequestParam Long cityId, 
            @RequestParam String establishedIn, @RequestParam MultipartFile playersList, @RequestParam String teamType) {
        log.debug("Creating a new team.");
        City teamCity = cityManager.getById(cityId);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date dtEstablishedIn = null;
        try {
            dtEstablishedIn = formatter.parse(establishedIn);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Team newTeam = new Team(teamName, founderName, description, address, achievements, teamCity, dtEstablishedIn, teamType);
        newTeam.setDisplayName(displayName);
        teamManager.save(newTeam);
        playerProfileManager.addPlayersListToTeam(newTeam, playersList);
        return new ModelAndView("redirect:/loadTeamDetails/team/"+newTeam.getTeamId()+"/weight/true/height/true/tournament/0");
    }

    @RequestMapping(value="/loadTeamDetails/team/{teamId}/weight/{isIncludeWeight}/height/{isIncludeHeight}/tournament/{tournamentId}", method=RequestMethod.GET)
    public ModelAndView loadTeamDetails(@PathVariable Long teamId, @PathVariable boolean isIncludeWeight, @PathVariable boolean isIncludeHeight,
            @PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("team/teamdetails");
        Team team = teamManager.getById(teamId, true);
        if(tournamentId.longValue() != 0) {
            Tournament tournamentDetails = tourManager.getById(tournamentId);
            team.setPlayersList(loadTeamPlayersFromTournamentParticipants(team, tournamentDetails));
        }
        List<Team> lstMenTeams = teamManager.getAllTeamsByTeamType(TeamType.MEN);
        List<Team> lstWomenTeams = teamManager.getAllTeamsByTeamType(TeamType.WOMEN);
        modelAndView.addObject("isIncludeWeight", isIncludeWeight);
        modelAndView.addObject("isIncludeHeight", isIncludeHeight);
        modelAndView.addObject("team", team);
        modelAndView.addObject("menTeamList", lstMenTeams);
        modelAndView.addObject("womenTeamList", lstWomenTeams);
        return modelAndView;
    }

    private List<PlayerProfile> loadTeamPlayersFromTournamentParticipants(Team team, Tournament tournament) {
        TournamentParticipant tourParticipant = tourParticipantManager.getByTeamAndTournament(team, tournament);
        List<TournamentParticipantTeam> listTourPartiTeam = tourPartiTeamManager.getByTournamentParticipantOrderByChaseNumber(tourParticipant);
        List<PlayerProfile> lstPlayerProfiles = new ArrayList<>();
        for(TournamentParticipantTeam tourPartiTeamProfile : listTourPartiTeam) {
            PlayerProfile playerProfile = playerProfileManager.getById(tourPartiTeamProfile.getPlayerProfileId());
            lstPlayerProfiles.add(playerProfile);
        }
        List<PlayerProfile> listCoachManager = playerProfileManager.getCoachManagerByTeam(team);
        lstPlayerProfiles.addAll(listCoachManager);
        return lstPlayerProfiles;
    }

    @RequestMapping(value="/fetchTeamPlayers/team/{teamId}/tournament/{tournamentId}", method=RequestMethod.GET)
    public ModelAndView loadTeamPlayers(@PathVariable Long teamId,@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("team/playerProfileDetails");
        Team teamDetails = teamManager.getById(teamId, true);
        List<PlayerProfile> lstPlayerProfiles = teamDetails.getPlayersList();
        TeamSponsorsDetails sponsorsDetails = null;
        if(tournamentId.longValue() != 0) {
            Tournament tournamentDetails = tourManager.getById(tournamentId);
            TournamentParticipant tourParticipant = tourParticipantManager.getByTeamAndTournament(teamDetails, tournamentDetails);
            lstPlayerProfiles = loadTeamPlayersFromTournamentParticipants(teamDetails, tournamentDetails);
            sponsorsDetails = sponsorsManager.getById(tourParticipant.getSponsorerId());
        } else {
            sponsorsDetails = new TeamSponsorsDetails();
        }
        modelAndView.addObject("sponsorsDetails", sponsorsDetails);
        modelAndView.addObject("teamDetails", teamDetails);
        modelAndView.addObject("listPlayerProfile", lstPlayerProfiles);
        return modelAndView;
    }
}
