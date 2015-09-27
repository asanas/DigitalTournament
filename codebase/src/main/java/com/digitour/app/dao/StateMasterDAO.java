package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.State;

public interface StateMasterDAO {

    public void persist(State transientInstance);
    public void attachDirty(State instance);

    public void attachClean(State instance);

    public void delete(State persistentInstance);
    public State merge(State detachedInstance);

    public State findById(java.lang.Long id);

    public List<State> findByExample(State instance);
}
