package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Team;

public interface TeamDAO {

    public Team save(Team transientInstance);

    public List<Team> getAll();

	public Team getById(Long teamId);
}
