package com.digitour.app.dao;

import com.digitour.app.db.model.TournamentMatchDetails;

public interface TournamentMatchDAO {

    public void save(TournamentMatchDetails tourMatchDetails);

    public TournamentMatchDetails getMatchDetailsById(Long matchId);
}
