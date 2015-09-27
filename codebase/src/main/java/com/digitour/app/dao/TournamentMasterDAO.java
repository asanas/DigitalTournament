package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.Tournament;


public interface TournamentMasterDAO {

    public void persist(Tournament transientInstance);

    public void attachDirty(Tournament instance);

    public void attachClean(Tournament instance);
    public void delete(Tournament persistentInstance);

    public Tournament merge(Tournament detachedInstance);

    public Tournament findById(java.lang.Long id);

    public List<Tournament> findByExample(Tournament instance);
}
