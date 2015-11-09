package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.TeamSponsorsDetails;

public interface TeamSponsorsDAO {
    List<TeamSponsorsDetails> getAllSponsors();

    TeamSponsorsDetails getById(Long sponsorerId);
}
