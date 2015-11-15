package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.support.enums.TeamType;

public interface TeamDAO {

    public Team save(Team transientInstance);

    public List<Team> getAll();

    public Team getById(Long teamId, Boolean loadPlayersList);

    public List<Team> getAllTeamsByTeamType(TeamType teamType);

    public List<Team> getAllByTournament(Tournament tournamentDetails);
}
