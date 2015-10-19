package com.digitour.app.controller.scoresheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.manager.TournamentMatchManager;

@Controller
public class MatchResultsController {

    @Autowired
    TournamentMatchManager matchManager;
    
    @RequestMapping(path = "/showMatchresults")
    public void showMatchResult(Long matchId, Long inning, Long turn) {
        if(inning ==0 && turn == 0) {
            loadMatchDetails(matchId);
        }
    }

    private void loadMatchDetails(Long matchId) {
        TournamentMatchDetails matchDetails = matchManager.getById(matchId);
        
    }
}
