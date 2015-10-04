package com.digitour.app.manager;

import com.digitour.app.db.model.TournamentMatchDetails;

public interface TournamentManager {
    public TournamentMatchDetails startQuickMatch(Long team1Id, Long team2Id, Long tossWonTeamId, String electedTo);
}
