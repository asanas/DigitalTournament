package com.digitour.app.dao;

import java.util.List;

import com.digitour.app.db.model.TeamSponsorerDetails;

public interface SponsorerDAO {
    List<TeamSponsorerDetails> getAllSponsorers();
}
