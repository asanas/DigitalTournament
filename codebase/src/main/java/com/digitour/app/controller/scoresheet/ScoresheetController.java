package com.digitour.app.controller.scoresheet;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.dao.PlayerProfileDAO;
import com.digitour.app.dao.TeamDAO;
import com.digitour.app.dao.TossDetailsDAO;
import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

@Controller
public class ScoresheetController {
    
    @Autowired
    TournamentMatchDAO tournamentDAO;
    
    @Autowired
    TeamDAO teamDAO;
    
    @Autowired
    TossDetailsDAO tossDetailsDAO;
    
    @Autowired
    TournamentParticipantDAO tournamentParticipantDAO;
    
    @Autowired
    TournamentParticipantTeamDAO tournamentParticipantTeamDAO;
    
    @Autowired
    PlayerProfileDAO playerProfileDAO;
    
    @RequestMapping(path ="/loadScoresheet/match/{matchId}/inning/{inning}/turn/{turn}", method=RequestMethod.GET)
    public ModelAndView showHomepage(@PathVariable Long matchId, @PathVariable Long inning, @PathVariable Long turn) {
        ModelAndView modelAndView = new ModelAndView("scoresheet/scoresheethome");
        TournamentMatchDetails tourMatchDetails = tournamentDAO.getMatchDetailsById(matchId);
        if(tourMatchDetails != null) {
            populateScoresheetData(modelAndView, tourMatchDetails);
        }
        return modelAndView;
    }

    private void populateScoresheetData(ModelAndView modelAndView, TournamentMatchDetails tournamentMatchDetails) {
        TournamentParticipant tournamentParticipant1 = tournamentParticipantDAO.getById(tournamentMatchDetails.getTeamParticipant1Id());
        TournamentParticipant tournamentParticipant2 = tournamentParticipantDAO.getById(tournamentMatchDetails.getTeamParticipant2Id());
        MatchTossDetails tossDetails = tossDetailsDAO.getTossDetailsByMatchId(tournamentMatchDetails.getTournamentMatchId());
        String tossWonMsg = createTossWonMessage(tournamentParticipant1, tournamentParticipant2, tossDetails);
        modelAndView.addObject("tossWonMessage", tossWonMsg);
        
        populateParticipatingTeams(tournamentMatchDetails, tournamentParticipant1, tournamentParticipant2, tossDetails, modelAndView);
    }

    private void populateParticipatingTeams(TournamentMatchDetails tournamentMatchDetails, TournamentParticipant tournamentParticipant1,
            TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails, ModelAndView modelAndView) {
        List<TournamentParticipantTeam> tournamentParticipantTeam1 = tournamentParticipantTeamDAO.getByTournamentParticipantByChaseNumber(tournamentParticipant1);
        List<TournamentParticipantTeam> tournamentParticipantTeam2 = tournamentParticipantTeamDAO.getByTournamentParticipantByChaseNumber(tournamentParticipant2);
        
        List<PlayerProfile> participatingTeam1 = getTeamPlayers(tournamentParticipantTeam1);
        List<PlayerProfile> participatingTeam2 = getTeamPlayers(tournamentParticipantTeam2);
        
        if("DEFENCE".equalsIgnoreCase(tossDetails.getElectedTo())) {
            if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId())) {
                modelAndView.addObject("defendingTeam", participatingTeam1);
                modelAndView.addObject("chasingTeam", participatingTeam2);
            } else {
                modelAndView.addObject("defendingTeam", participatingTeam2);
                modelAndView.addObject("chasingTeam", participatingTeam1);
            }
        } else {
            if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId())) {
                modelAndView.addObject("defendingTeam", participatingTeam2);
                modelAndView.addObject("chasingTeam", participatingTeam1);
            } else {
                modelAndView.addObject("defendingTeam", participatingTeam1);
                modelAndView.addObject("chasingTeam", participatingTeam2);
            }
        }
    }

    private List<PlayerProfile> getTeamPlayers(List<TournamentParticipantTeam> tournamentParticipantTeam1) {
        List<PlayerProfile> listPlayers = new ArrayList<PlayerProfile>();
        for(TournamentParticipantTeam tournamentParticipant: tournamentParticipantTeam1) {
            PlayerProfile playerProfile = playerProfileDAO.getById(tournamentParticipant.getPlayerProfileId());
            playerProfile.setTournamentChaseNumber(tournamentParticipant.getPlayerChaseNumber());
            listPlayers.add(playerProfile);
        }
        return listPlayers;
    }

    private String createTossWonMessage(TournamentParticipant tournamentParticipant1, TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails) {
        String tossWonMsg = "Toss won by ";
        Team team = null;
        if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId())) {
            team = teamDAO.getById(tournamentParticipant1.getTeamId());
        } else {
            team = teamDAO.getById(tournamentParticipant2.getTeamId());
        }
        tossWonMsg = tossWonMsg + team.getName() + " And elected to " + tossDetails.getElectedTo();
        return tossWonMsg;
    }
}
