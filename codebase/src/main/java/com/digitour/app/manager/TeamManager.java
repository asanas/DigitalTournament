package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.Team;

public interface TeamManager {

	List<Team> getAll();

    Team getById(Long teamId, Boolean loadPlayersList);

}
