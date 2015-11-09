package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.TeamSponsorsDAO;
import com.digitour.app.db.model.TeamSponsorsDetails;
import com.digitour.app.manager.TeamSponsorsManager;

@Service
public class SponsorerManagerImpl implements TeamSponsorsManager {

    @Autowired
    TeamSponsorsDAO sponsorerDAO;

    @Override
    public List<TeamSponsorsDetails> getAllSponsorers() {
        return sponsorerDAO.getAllSponsors();
    }

    @Override
    public TeamSponsorsDetails getById(Long sponsorerId) {
        return sponsorerDAO.getById(sponsorerId);
    }

}
