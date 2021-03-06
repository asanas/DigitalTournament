package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.TeamDAO;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.support.enums.TeamType;
import com.digitour.app.manager.TeamManager;

@Service
public class TeamManagerImpl implements TeamManager {

    @Autowired
    TeamDAO teamDAO;
    
    @Override
    public List<Team> getAll() {
        return teamDAO.getAll();
    }

    @Override
    public void save(Team team) {
        teamDAO.save(team);
    }

    @Override
    public Team getById(Long teamId, Boolean loadPlayersList) {
        return teamDAO.getById(teamId, loadPlayersList);
    }

    @Override
    public List<Team> getAllTeamsByTeamType(TeamType teamType) {
        return teamDAO.getAllTeamsByTeamType(teamType);
    }

    @Override
    public List<Team> getAllByTournament(Tournament tournamentDetails) {
        return teamDAO.getAllByTournament(tournamentDetails);
    }

}
