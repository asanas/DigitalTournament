package com.digitour.app.dao;

import com.digitour.app.db.model.FoulDetails;
import com.digitour.app.db.model.MatchFoulDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchFoulMasterDAO {
	
	public Long getFoulsCountParticipantForMatch(FoulDetails foulDetails, TournamentMatchDetails tournamentMatchDetails,
			Long tournamentPartipantId, Long inning);

	public void save(MatchFoulDetails newMatchFoulDetails);

    public void removeFoulForMatch(MatchFoulDetails matchFoulDetails);
}
