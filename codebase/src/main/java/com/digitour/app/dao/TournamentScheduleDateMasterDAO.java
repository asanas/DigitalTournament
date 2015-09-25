package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.TournamentScheduleDateMaster;

public interface TournamentScheduleDateMasterDAO {

    public void persist(TournamentScheduleDateMaster transientInstance);

    public void attachDirty(TournamentScheduleDateMaster instance);

    public void attachClean(TournamentScheduleDateMaster instance);

    public void delete(TournamentScheduleDateMaster persistentInstance);

    public TournamentScheduleDateMaster merge(TournamentScheduleDateMaster detachedInstance);

    public TournamentScheduleDateMaster findById(java.lang.Long id);

    public List<TournamentScheduleDateMaster> findByExample(TournamentScheduleDateMaster instance);
}
