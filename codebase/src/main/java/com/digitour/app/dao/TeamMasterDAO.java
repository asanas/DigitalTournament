package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Team;

public interface TeamMasterDAO {

    public void persist(Team transientInstance);

    public void attachDirty(Team instance);

    public void attachClean(Team instance);
    public void delete(Team persistentInstance);
    public Team merge(Team detachedInstance);

    public Team findById(java.lang.Long id);
    public List<Team> findByExample(Team instance);
}
