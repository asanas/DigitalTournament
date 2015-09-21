package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TournamentMaster;


public interface TournamentMasterDAO {

    public void persist(TournamentMaster transientInstance);

    public void attachDirty(TournamentMaster instance);

    public void attachClean(TournamentMaster instance);
    public void delete(TournamentMaster persistentInstance);

    public TournamentMaster merge(TournamentMaster detachedInstance);

    public TournamentMaster findById(java.lang.Long id);

    public List<TournamentMaster> findByExample(TournamentMaster instance);
}
