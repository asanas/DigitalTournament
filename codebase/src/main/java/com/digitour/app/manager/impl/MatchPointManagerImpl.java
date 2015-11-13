package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.client.pojo.PlayerPerformace;
import com.digitour.app.dao.MatchPointDetailsDAO;
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
    MatchPointDetailsDAO matchPointDAO;
    
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
        matchPoint.setTurnClosure(!out);
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

    @Override
    public Long getTotalMatchPointsForTheTeam(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam1) {
        return matchPointDAO.getTotalMatchPointsForTheTeam(matchDetails, participantTeam1);
    }

    
    @Override
    public Long getMaxRunTimeByMatchInningAndTurn(TournamentMatchDetails tournamentMatchDetails, Long inning,
            Long turn) {
        return matchPointDAO.getMaxRunTimeByMatchInningAndTurn(tournamentMatchDetails, inning, turn);
    }

    @Override
    public List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails,
            Long tournamentParticipantPlayerId, Long inning, Long turn) {
        return matchPointDAO.getMatchPointsByInningTurnAndDefender(tournamentMatchDetails, tournamentParticipantPlayerId, inning, turn);
    }

    @Override
    public List<MatchPointDetails> getTopDefendersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam) {
        return matchPointDAO.getTopDefendersListByMatch(matchDetails, participantTeam);
    }

    @Override
    public List<PlayerPerformace> getTopAttackersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam) {
        return matchPointDAO.getTopAttackersListByMatch(matchDetails, participantTeam);
    }

    @Override
    public Long getTotalMatchPointsForTheTeamByInning(Long inning, TournamentMatchDetails tournamentMatchDetails,
            List<TournamentParticipantTeam> defendingParticipantTeam) {
        return matchPointDAO.getTotalMatchPointsForTheTeamByInning(inning, tournamentMatchDetails, defendingParticipantTeam);
    }
}
