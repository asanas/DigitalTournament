package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.support.enums.TeamType;

public interface TeamManager {

    List<Team> getAll();

    Team getById(Long teamId, Boolean loadPlayersList);

    void save(Team team);

    List<Team> getAllTeamsByTeamType(TeamType men);

    List<Team> getAllByTournament(Tournament tournamentDetails);
}
