package com.digitour.app.manager;

import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface TournamentManager {
    public TournamentMatchDetails startQuickMatch(Long team1Id, Long team2Id, Long tossWonTeamId, String electedTo);

    public void save(Tournament tournament);

    public Tournament getById(Long tournamentId);
}
