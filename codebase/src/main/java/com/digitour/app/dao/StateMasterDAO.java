package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.StateMaster;

public interface StateMasterDAO {

    public void persist(StateMaster transientInstance);
    public void attachDirty(StateMaster instance);

    public void attachClean(StateMaster instance);

    public void delete(StateMaster persistentInstance);
    public StateMaster merge(StateMaster detachedInstance);

    public StateMaster findById(java.lang.Long id);

    public List<StateMaster> findByExample(StateMaster instance);
}
