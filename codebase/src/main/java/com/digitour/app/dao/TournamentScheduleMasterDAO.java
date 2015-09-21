package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.TournamentScheduleMaster;

public interface TournamentScheduleMasterDAO {

    public void persist(TournamentScheduleMaster transientInstance);

    public void attachDirty(TournamentScheduleMaster instance);

    public void attachClean(TournamentScheduleMaster instance);

    public void delete(TournamentScheduleMaster persistentInstance);

    public TournamentScheduleMaster merge(TournamentScheduleMaster detachedInstance);

    public TournamentScheduleMaster findById(java.lang.Long id);

    public List<TournamentScheduleMaster> findByExample(TournamentScheduleMaster instance);
}
