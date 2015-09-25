package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.example.TournamentMatchResultMaster;

public interface TournamentMatchResultMasterDAO {

    public void persist(TournamentMatchResultMaster transientInstance);
    public void attachDirty(TournamentMatchResultMaster instance);

    public void attachClean(TournamentMatchResultMaster instance);
    public void delete(TournamentMatchResultMaster persistentInstance);

    public TournamentMatchResultMaster merge(TournamentMatchResultMaster detachedInstance);
    public TournamentMatchResultMaster findById(java.lang.Long id);
    public List<TournamentMatchResultMaster> findByExample(TournamentMatchResultMaster instance);
}
