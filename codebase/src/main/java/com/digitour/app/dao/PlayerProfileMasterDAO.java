package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.model.PlayerProfileMaster;

public interface PlayerProfileMasterDAO {

    public void persist(PlayerProfileMaster transientInstance);
    public void attachDirty(PlayerProfileMaster instance);

    public void attachClean(PlayerProfileMaster instance);
    public void delete(PlayerProfileMaster persistentInstance);

    public PlayerProfileMaster merge(PlayerProfileMaster detachedInstance);

    public PlayerProfileMaster findById(java.lang.Long id);

    public List<PlayerProfileMaster> findByExample(PlayerProfileMaster instance);
}
