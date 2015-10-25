package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.dao.SymbolMasterDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.Symbol;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.manager.MatchTurnManager;
import com.digitour.app.manager.ScoresheetManager;
import com.digitour.app.manager.TeamManager;

@Repository
public class ScoresheetManagerImpl implements ScoresheetManager {

    @Autowired
    TeamManager teamManager;
    
    @Autowired
    MatchTurnManager turnManager;

    // TODO: remove direct call to other DAO
    @Autowired
    SymbolMasterDAO symbolDAO;

    @Override
    public String createTossWonMessage(TournamentParticipant tournamentParticipant1, TournamentParticipant tournamentParticipant2, MatchTossDetails tossDetails) {
        String tossWonMsg = "Toss won by ";
        Team team = null;
        if(tossDetails.getTossWonByTeamId().equals(tournamentParticipant1.getTourParticipantId())) {
            team = teamManager.getById(tournamentParticipant1.getTeamId(), false);
        } else {
            team = teamManager.getById(tournamentParticipant2.getTeamId(), false);
        }
        tossWonMsg = tossWonMsg + team.getTeamName() + " And elected to " + tossDetails.getElectedTo();
        return tossWonMsg;
    }
    @Override
    public List<Symbol> populateSymbols(ModelAndView modelAndView) {
        return symbolDAO.getAllSymbols();
    }
    @Override
    public List<MatchTurnDetails> populateTurns(ModelAndView modelAndView,
            TournamentMatchDetails tournamentMatchDetails) {
        return turnManager.getTurnsByMatch(tournamentMatchDetails);
    }

}
