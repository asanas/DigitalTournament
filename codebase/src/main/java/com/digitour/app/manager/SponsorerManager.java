package com.digitour.app.manager;

import java.util.List;

import com.digitour.app.db.model.TeamSponsorerDetails;

public interface SponsorerManager {
    List<TeamSponsorerDetails> getAllSponsorers();
}
