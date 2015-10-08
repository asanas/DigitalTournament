package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipantTeam;

public interface MatchPointMasterDAO {

    public List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails, Long tournamentParticipantPlayerId,
            Long inning, Long turn);

	public void save(MatchPointDetails matchPoint);

    public Long getMaxRunTimeByMatchInningAndTurn(TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn);

	public Long getTotalMatchPointsForTheTeam(TournamentMatchDetails tournamentMatchDetails,
			List<TournamentParticipantTeam> chasingParticipantTeam);
}
