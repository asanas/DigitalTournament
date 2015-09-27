package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TournamentMatchFoulMaster;

public interface TournamentMatchFoulMasterDAO {

    public void persist(TournamentMatchFoulMaster transientInstance);

    public void attachDirty(TournamentMatchFoulMaster instance);

    public void attachClean(TournamentMatchFoulMaster instance);

    public void delete(TournamentMatchFoulMaster persistentInstance);
    public TournamentMatchFoulMaster merge(TournamentMatchFoulMaster detachedInstance);

    public TournamentMatchFoulMaster findById(java.lang.Long id);

    public List<TournamentMatchFoulMaster> findByExample(TournamentMatchFoulMaster instance);
}
