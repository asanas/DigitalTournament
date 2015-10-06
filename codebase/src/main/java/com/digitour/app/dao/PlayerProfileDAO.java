package com.digitour.app.dao;

import com.digitour.app.db.model.PlayerProfile;

public interface PlayerProfileDAO {

    public void save(PlayerProfile transientInstance);

    public PlayerProfile getById(Long playerProfileId);
}
