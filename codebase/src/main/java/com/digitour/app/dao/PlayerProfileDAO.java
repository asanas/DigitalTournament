package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;

public interface PlayerProfileDAO {

    public void save(PlayerProfile transientInstance);

    public PlayerProfile getById(Long playerProfileId);

    public List<PlayerProfile> getCoachManagerByTeam(Team team);
}
