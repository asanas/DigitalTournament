package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.MatchPointDetails;

public interface MatchPointMasterDAO {

    public void persist(MatchPointDetails transientInstance);
    public void attachDirty(MatchPointDetails instance);

    public void attachClean(MatchPointDetails instance);

    public void delete(MatchPointDetails persistentInstance);

    public MatchPointDetails merge(MatchPointDetails detachedInstance);

    public MatchPointDetails findById(java.lang.Long id);

    public List<MatchPointDetails> findByExample(MatchPointDetails instance);
}
