package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.support.enums.Gender;

public interface TeamDAO {

    public Team save(Team transientInstance);

    public List<Team> getAll();

	public Team getById(Long teamId);

	public List<Team> getAllTeamsByGender(Gender gender);
}
