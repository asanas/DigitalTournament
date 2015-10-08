package com.digitour.app.dao;

import com.digitour.app.db.model.MatchTurnDetails;

public interface MatchTurnDAO {
    MatchTurnDetails getInningDetailsByMatchInningAndTurnNumber(Long matchId, Long inning, Long turn);

    void save(MatchTurnDetails matchTurn);
}
