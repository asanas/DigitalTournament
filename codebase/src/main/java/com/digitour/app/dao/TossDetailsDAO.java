package com.digitour.app.dao;

import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface TossDetailsDAO {


	public void save(MatchTossDetails matchToss);

    public MatchTossDetails getTossDetailsByMatch(TournamentMatchDetails tournamentMatchDetails);
}
