package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.MatchPointMaster;

public interface MatchPointMasterDAO {

    public void persist(MatchPointMaster transientInstance);
    public void attachDirty(MatchPointMaster instance);

    public void attachClean(MatchPointMaster instance);

    public void delete(MatchPointMaster persistentInstance);

    public MatchPointMaster merge(MatchPointMaster detachedInstance);

    public MatchPointMaster findById(java.lang.Long id);

    public List<MatchPointMaster> findByExample(MatchPointMaster instance);
}
