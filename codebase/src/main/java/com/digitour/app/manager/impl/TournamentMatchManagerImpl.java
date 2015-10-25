package com.digitour.app.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.TournamentMatchDAO;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.manager.TournamentMatchManager;

@Service
public class TournamentMatchManagerImpl implements TournamentMatchManager {

	@Autowired
	TournamentMatchDAO matchDAO;
    @Override
    public TournamentMatchDetails getById(Long matchId) {
        return matchDAO.getMatchDetailsById(matchId);
    }

}
