package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TournamentGroupDetailsMaster;

public interface TournamentGroupDetailsMasterDAO {

    public void persist(TournamentGroupDetailsMaster transientInstance);
    public void attachDirty(TournamentGroupDetailsMaster instance);

    public void attachClean(TournamentGroupDetailsMaster instance);
    public void delete(TournamentGroupDetailsMaster persistentInstance);

    public TournamentGroupDetailsMaster merge(TournamentGroupDetailsMaster detachedInstance);
    public TournamentGroupDetailsMaster findById(java.lang.Long id);
    public List<TournamentGroupDetailsMaster> findByExample(TournamentGroupDetailsMaster instance);
}
