package com.digitour.app.dao;

import com.digitour.app.db.model.FoulDetails;
import com.digitour.app.db.model.MatchFoulDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchFoulMasterDAO {
	
	public Long getFoulsCountByInningAndParticipantForMatch(FoulDetails foulDetails, TournamentMatchDetails tournamentMatchDetails,
			Long tournamentPartipantId, Long inning);

	public void save(MatchFoulDetails newMatchFoulDetails);
}
