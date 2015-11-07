package com.digitour.app.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.SponsorerDAO;
import com.digitour.app.db.model.TeamSponsorerDetails;
import com.digitour.app.manager.SponsorerManager;

@Service
public class SponsorerManagerImpl implements SponsorerManager {

    @Autowired
    SponsorerDAO sponsorerDAO;

    @Override
    public List<TeamSponsorerDetails> getAllSponsorers() {
        return sponsorerDAO.getAllSponsorers();
    }

}
