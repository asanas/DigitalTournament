package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchTurnManager {
    List<MatchTurnDetails> getTurnsByMatch(TournamentMatchDetails matchDetails);
    void save(MatchTurnDetails turnDetails);
    void createMatchTurns(TournamentMatchDetails tournamentMatch);
    void addInning(TournamentMatchDetails tournamentMatch);
}
