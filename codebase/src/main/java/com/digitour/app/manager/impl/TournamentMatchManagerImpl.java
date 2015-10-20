package com.digitour.app.manager.impl;

import org.springframework.stereotype.Service;

import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.manager.TournamentMatchManager;

@Service
public class TournamentMatchManagerImpl implements TournamentMatchManager {

    @Override
    public TournamentMatchDetails getById(Long matchId) {
        return null;
    }

}
