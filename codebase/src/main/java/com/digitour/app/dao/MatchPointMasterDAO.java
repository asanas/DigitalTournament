package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchPointMasterDAO {

    public List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails, Long tournamentParticipantPlayerId,
            Long inning, Long turn);

	public void save(MatchPointDetails matchPoint);
}
