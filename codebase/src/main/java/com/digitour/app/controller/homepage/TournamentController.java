package com.digitour.app.controller.homepage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TeamSponsorsManager;
import com.digitour.app.manager.TournamentManager;
import com.digitour.app.manager.TournamentParticipantManager;
import com.digitour.app.ui.component.menu.Menu;

@Controller
public class TournamentController {

    private static final String MAIN_MENU = "main_menu";

    @Autowired
    TournamentManager tourManager;

    @Autowired
    TeamManager teamManager;

    @Autowired
    TeamSponsorsManager sponsorerManager;
    
    @Autowired
    TournamentParticipantManager tourParticiapantManager;
    
    
    @RequestMapping(value="/createnew/tournament", method=RequestMethod.GET)
    public ModelAndView showCreateTournamentForm() {
        ModelAndView modelAndView = new ModelAndView("tournament/createnewtournament");
        return modelAndView;
    }

    @RequestMapping( value="/tournament/{tournamentId}/home", method=RequestMethod.GET)
    public ModelAndView showTournamentHome(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("tournament/tournamentHome");
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        modelAndView.addObject("tournamentHomeMenus", createTournamentHomepageMenus(tournamentDetails));
        modelAndView.addObject("tournamentDetails", tournamentDetails);
        modelAndView.addObject("tournamentName", tournamentDetails.getTournamentName());
        return modelAndView;
    }

    @RequestMapping(value="/createnew/tournament", method=RequestMethod.POST)
    public ModelAndView handleCreateNewTournament(@RequestParam String tourName, @RequestParam String tourDescription, @RequestParam String tourLocation, 
            @RequestParam String startDate, @RequestParam String endDate, @RequestParam String ageGroup, @RequestParam String prize) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectparticipatingteams");
        modelAndView.addObject("tournamentName", tourName);
        // add tournament details and pass it on to client side for reference
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date tournamentStartDate = null;
        Date tournamentEndDate = null;
        try {
            tournamentStartDate = formatter.parse(startDate);
            tournamentEndDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tournament tournament = new Tournament(tourName, tourDescription, tourLocation, tournamentStartDate, tournamentEndDate, ageGroup, prize);
        tourManager.save(tournament);
        return new ModelAndView("redirect:/selectTournamentParticipant/tournament/"+tournament.getTournamentId());
    }

    @RequestMapping(value="/selectTournamentParticipant/tournament/{tournamentId}", method=RequestMethod.GET)
    public ModelAndView handleCreateNewTournament(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectparticipatingteams");
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        modelAndView.addObject("tournamentDetails", tournamentDetails);
        modelAndView.addObject("tournamentName", tournamentDetails.getTournamentName());
        modelAndView.addObject("teamList", teamManager.getAll());
        // add support for sponsorer details
        modelAndView.addObject("sponsorerList", sponsorerManager.getAllSponsorers());
        return modelAndView;
    }

    @RequestMapping(value="/tournament/{tournamentId}/nextMatch", method=RequestMethod.GET)
    public ModelAndView selectTournamentNextMatch(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("home/startquickmatch");
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        modelAndView.addObject("tournamentDetails", tournamentDetails);
        modelAndView.addObject("tournamentName", tournamentDetails.getTournamentName());
        modelAndView.addObject("teamList", teamManager.getAllByTournament(tournamentDetails));
        // add support for sponsorer details
        modelAndView.addObject("sponsorerList", sponsorerManager.getAllSponsorers());
        return modelAndView;
    }

    @RequestMapping(value="/tournament/{tournamentId}/markTourInProgress", method=RequestMethod.GET)
    @ResponseBody
    public String markTournamentInProgressAndGotoHome(@PathVariable Long tournamentId) {
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        tournamentDetails.setTourStatus("INPROGRESS");
        tourManager.save(tournamentDetails);
        return "success";
    }

    private List<Menu> createTournamentHomepageMenus(Tournament tournamentDetails) {
        List<Menu> lstMenu = new ArrayList<Menu>();
        Menu nextMatch = new Menu();
        nextMatch.setMenuURL("tournament/" + tournamentDetails.getTournamentId() + "/nextMatch");
        nextMatch.setClassName(MAIN_MENU);
        nextMatch.setMenuDescription("Next match");
        nextMatch.setDisplayText("Next match");
        
        Menu leaderboard = new Menu();
        leaderboard.setMenuURL("javascript:void();");
        leaderboard.setClassName(MAIN_MENU);
        leaderboard.setMenuDescription("Leaderboard");
        leaderboard.setDisplayText("Leaderboard");
        leaderboard.setJsFunctionCall("showAlert('Coming Soon');");

        Menu teams = new Menu();
        teams.setMenuURL("tournament/participatingTeams");
        teams.setClassName(MAIN_MENU);
        teams.setMenuDescription("Teams");
        teams.setDisplayText("Teams");
        
        Menu tourSponsors = new Menu();
        tourSponsors.setMenuURL("tournament/sponsorsHome");
        tourSponsors.setClassName(MAIN_MENU);
        tourSponsors.setMenuDescription("Tournament Sponsors");
        tourSponsors.setDisplayText("Tournament Sponsors");
        
        lstMenu.add(nextMatch);
        lstMenu.add(leaderboard);
        lstMenu.add(teams);
        lstMenu.add(tourSponsors);
        return lstMenu;
    }
    
    @RequestMapping(value="/tournament/addParticipants/", method=RequestMethod.POST)
    @ResponseBody
    public String handleAddParticipants(@RequestParam Long tournamentId, @RequestParam String teams) {
        Tournament tournament = tourManager.getById(tournamentId);
        String[] strTeamIds = teams.split(",");
        for(String strTeamId : strTeamIds) {
            Long teamId = Long.parseLong(strTeamId);
            tourManager.createTourPartipant(tournament, teamId);
        }
        return "success";
    }

    @RequestMapping(value="/tournament/{tournamentId}/team/{teamId}/saveChaseNumbers", method=RequestMethod.POST)
    @ResponseBody
    public String addParticipantsChaseNumbers(@PathVariable Long tournamentId, @PathVariable Long teamId, 
            @RequestParam String playerProfileChaseNumberMap) {
        Tournament tournament = tourManager.getById(tournamentId);
        Team team = teamManager.getById(teamId, false);

        tourParticiapantManager.createTournamentParticipantTeamByChaseNumber(tournament, team, playerProfileChaseNumberMap);
        return "success";
    }

    @RequestMapping(value="/tournament/{tournamentId}/participants/selectChaseNumbers", method=RequestMethod.GET)
    public ModelAndView selectParticipantsChaseNumbers(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectParticipantsChasenumber");
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        List<TournamentParticipant> lstTournamentParticipant = tourParticiapantManager.getByTournament(tournamentDetails);
        List<Team> teamList = new ArrayList<>();
        for(TournamentParticipant tourParticipant : lstTournamentParticipant) {
            Team team = teamManager.getById(tourParticipant.getTeamId(), true);
            teamList.add(team);
        }
        modelAndView.addObject("tournamentDetails", tournamentDetails);
        modelAndView.addObject("teamList", teamList);
        return modelAndView;
    }
}
