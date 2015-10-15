package com.digitour.app.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.MatchPointMasterDAO;
import com.digitour.app.dao.SymbolMasterDAO;
import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Symbol;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;
import com.digitour.app.manager.MatchPointManager;

@Service
public class MatchPointManagerImpl implements MatchPointManager {

    @Autowired
    TournamentParticipantTeamDAO tournamentParticipantTeamDAO;
    
    @Autowired
    TournamentParticipantDAO tournamentParticipantDAO;
    
    @Autowired
    SymbolMasterDAO symbolDAO;
    
    @Autowired
    MatchPointMasterDAO matchPointDAO;
    
    @Override
    public void addMatchPointDetails(TournamentMatchDetails matchDetails, PlayerProfile defenderPlayerProfile, PlayerProfile chaserPlayerProfile, Long timePlayed,
            Long runTime, Long inning, Long turn, Long symbolId, Boolean out) {
        TournamentParticipant defenderParticipant = tournamentParticipantDAO.getTournamentParticipantByTeamAndTournament(defenderPlayerProfile.getTeam(), 
                matchDetails.getTournamentId());
        TournamentParticipantTeam defenderProfileTourTeam = tournamentParticipantTeamDAO.getByPlayerProfileAndTournamentParticipant(defenderPlayerProfile, defenderParticipant);
        Symbol symbol = symbolDAO.getById(symbolId);
        MatchPointDetails matchPoint = new MatchPointDetails();
        matchPoint.setDefenceParticipantProfileId(defenderProfileTourTeam.getTournamentParticipantPlayerId());
        matchPoint.setMatchId(matchDetails.getTournamentMatchId());
        matchPoint.setSymbol(symbol);
        matchPoint.setOut(out);
        matchPoint.setTurnClosure(false);
        matchPoint.setPerTime(timePlayed);
        matchPoint.setRunTime(runTime);
        matchPoint.setTurnNumber(turn);
        matchPoint.setInningNumber(inning);

        if(chaserPlayerProfile != null) {
            TournamentParticipant chaserParticipant = tournamentParticipantDAO.getTournamentParticipantByTeamAndTournament(chaserPlayerProfile.getTeam(), 
                    matchDetails.getTournamentId());
            TournamentParticipantTeam chaserProfileTourTeam = tournamentParticipantTeamDAO.getByPlayerProfileAndTournamentParticipant(chaserPlayerProfile, chaserParticipant);
            matchPoint.setAttackParticipantProfileId(chaserProfileTourTeam.getTournamentParticipantPlayerId());
            matchPoint.setAssistParticipantProfileId(chaserProfileTourTeam.getTournamentParticipantPlayerId());
        }
        matchPointDAO.save(matchPoint);
    }

}
