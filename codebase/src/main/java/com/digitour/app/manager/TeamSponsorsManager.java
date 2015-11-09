package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.TeamSponsorsDetails;

public interface TeamSponsorsManager {
    List<TeamSponsorsDetails> getAllSponsorers();

    TeamSponsorsDetails getById(Long sponsorerId);
}
