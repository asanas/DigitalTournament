package com.digitour.app.manager;

import com.digitour.app.db.model.TournamentMatchDetails;

public interface TournamentMatchManager {

    TournamentMatchDetails getById(Long matchId);

}
