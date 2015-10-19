package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.TeamDAO;
import com.digitour.app.db.model.Team;
import com.digitour.app.manager.TeamManager;

@Service
public class TeamManagerImpl implements TeamManager {

    @Autowired
    TeamDAO teamDAO;
    
    @Override
    public List<Team> getAll() {
        return teamDAO.getAll();
    }

	public void save(Team team) {
		teamDAO.save(team);
	}

    @Override
    public Team getById(Long teamId)
    {
        return teamDAO.getById(teamId);
    }

}
