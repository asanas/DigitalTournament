package com.digitour.app.manager;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentMatchDetails;

public interface MatchPointManager {
    void addMatchPointDetails(TournamentMatchDetails matchDetails, PlayerProfile defenderProfile, 
            PlayerProfile chaserProfile, Long timePlayed, Long runTime, Long inning, Long turn, Long symbolId, Boolean out);
}
