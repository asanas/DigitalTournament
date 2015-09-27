package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.PlayerProfile;

public interface PlayerProfileMasterDAO {

    public void persist(PlayerProfile transientInstance);
    public void attachDirty(PlayerProfile instance);

    public void attachClean(PlayerProfile instance);
    public void delete(PlayerProfile persistentInstance);

    public PlayerProfile merge(PlayerProfile detachedInstance);

    public PlayerProfile findById(java.lang.Long id);

    public List<PlayerProfile> findByExample(PlayerProfile instance);
}
