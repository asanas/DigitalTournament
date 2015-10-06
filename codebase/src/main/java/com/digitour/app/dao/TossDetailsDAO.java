package com.digitour.app.dao;

import com.digitour.app.db.model.MatchTossDetails;

public interface TossDetailsDAO {


	public void save(MatchTossDetails matchToss);

    public MatchTossDetails getTossDetailsByMatchId(Long tournamentMatchId);
}
