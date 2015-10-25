package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface MatchPointDetailsDAO {

    public List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails, Long tournamentParticipantPlayerId,
            Long inning, Long turn);

    public void save(MatchPointDetails matchPoint);

    public Long getMaxRunTimeByMatchInningAndTurn(TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn);

    public Long getTotalMatchPointsForTheTeam(TournamentMatchDetails tournamentMatchDetails, List<TournamentParticipantTeam> participantTeam1);

    public Long getCurrentInningPointsForTheTeam(TournamentMatchDetails tournamentMatchDetails,
            List<TournamentParticipantTeam> defendingParticipatingTeam, Long inning, Long turn);

    public List<MatchPointDetails> getTopDefendersList(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam);
}
