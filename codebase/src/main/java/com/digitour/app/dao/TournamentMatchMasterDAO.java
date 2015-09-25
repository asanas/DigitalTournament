package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.TournamentMatchMaster;

public interface TournamentMatchMasterDAO {

    public void persist(TournamentMatchMaster transientInstance);
    public void attachDirty(TournamentMatchMaster instance);

    public void attachClean(TournamentMatchMaster instance);

    public void delete(TournamentMatchMaster persistentInstance);
    public TournamentMatchMaster merge(TournamentMatchMaster detachedInstance);

    public TournamentMatchMaster findById(java.lang.Long id);

    public List<TournamentMatchMaster> findByExample(TournamentMatchMaster instance);
}
