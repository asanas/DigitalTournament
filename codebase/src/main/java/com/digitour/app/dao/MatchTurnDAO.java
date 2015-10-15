package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchTurnDAO {
    MatchTurnDetails getInningDetailsByMatchInningAndTurnNumber(TournamentMatchDetails matchDetails, Long inning, Long turn);

    void save(MatchTurnDetails matchTurn);

    List<MatchTurnDetails> getTurnsByMatch(TournamentMatchDetails matchDetails);
}
