package com.digitour.app.controller.scoresheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.manager.TournamentMatchManager;
import com.digitour.app.manager.TournamentParticipantManager;

@Controller
public class MatchResultsController {

    @Autowired
    TournamentMatchManager matchManager;
    
    @Autowired
    TournamentParticipantManager participantManager;
    
    @RequestMapping(path = "/showMatchResults", method = RequestMethod.GET)
    public ModelAndView showMatchResult(Long matchId, Long inning, Long turn) {
        return loadMatchDetails(matchId);	
    }

    private ModelAndView loadMatchDetails(Long matchId) {
        TournamentMatchDetails matchDetails = matchManager.getById(matchId);
        ModelAndView modelAndView = new ModelAndView("result/match-result");
        TournamentParticipant tournamentParticipant1 = participantManager.getById(matchDetails.getTeamParticipant1Id());
        TournamentParticipant tournamentParticipant2 = participantManager.getById(matchDetails.getTeamParticipant2Id());
        
        return modelAndView;
    }
}
