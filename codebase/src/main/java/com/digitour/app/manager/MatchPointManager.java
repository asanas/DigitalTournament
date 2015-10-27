package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.client.pojo.PlayerPerformace;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface MatchPointManager {
    void addMatchPointDetails(TournamentMatchDetails matchDetails, PlayerProfile defenderProfile, 
            PlayerProfile chaserProfile, Long timePlayed, Long runTime, Long inning, Long turn, Long symbolId, Boolean out);

    Long getTotalMatchPointsForTheTeam(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam1);

    Long getMaxRunTimeByMatchInningAndTurn(TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn);

    List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails,
            Long tournamentParticipantPlayerId, Long inning, Long turn);

    List<MatchPointDetails> getTopDefendersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam1);

    List<PlayerPerformace> getTopAttackersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam2);
}
