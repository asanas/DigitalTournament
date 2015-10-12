package com.digitour.app.dao;

import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchTurnDAO {
    MatchTurnDetails getInningDetailsByMatchInningAndTurnNumber(TournamentMatchDetails matchDetails, Long inning, Long turn);

    void save(MatchTurnDetails matchTurn);
}
