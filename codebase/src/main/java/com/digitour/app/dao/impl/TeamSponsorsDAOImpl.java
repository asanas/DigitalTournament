package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.TeamSponsorsDAO;
import com.digitour.app.db.model.TeamSponsorsDetails;

@Repository
public class TeamSponsorsDAOImpl implements TeamSponsorsDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    public List<TeamSponsorsDetails> getAllSponsors() {
        return this.hibernateTemplate.loadAll(TeamSponsorsDetails.class);
    }

    @Override
    public TeamSponsorsDetails getById(Long sponsorerId) {
        return (TeamSponsorsDetails)this.hibernateTemplate.load(TeamSponsorsDetails.class, sponsorerId);
    }

}
