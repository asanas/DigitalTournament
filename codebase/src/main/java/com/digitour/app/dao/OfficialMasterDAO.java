package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.TournamentOfficial;

public interface OfficialMasterDAO {

    public void persist(TournamentOfficial transientInstance);

    public void attachDirty(TournamentOfficial instance);

    public void attachClean(TournamentOfficial instance);

    public void delete(TournamentOfficial persistentInstance);
    public TournamentOfficial merge(TournamentOfficial detachedInstance);
    public TournamentOfficial findById(java.lang.Long id);
    public List<TournamentOfficial> findByExample(TournamentOfficial instance);
}
