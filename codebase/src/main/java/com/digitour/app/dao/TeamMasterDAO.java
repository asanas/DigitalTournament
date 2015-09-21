package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TeamMaster;

public interface TeamMasterDAO {

    public void persist(TeamMaster transientInstance);

    public void attachDirty(TeamMaster instance);

    public void attachClean(TeamMaster instance);
    public void delete(TeamMaster persistentInstance);
    public TeamMaster merge(TeamMaster detachedInstance);

    public TeamMaster findById(java.lang.Long id);
    public List<TeamMaster> findByExample(TeamMaster instance);
}
