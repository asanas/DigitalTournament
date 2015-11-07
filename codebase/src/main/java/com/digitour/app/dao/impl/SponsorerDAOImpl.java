package com.digitour.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.SponsorerDAO;
import com.digitour.app.db.model.TeamSponsorerDetails;

@Repository
public class SponsorerDAOImpl implements SponsorerDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    public List<TeamSponsorerDetails> getAllSponsorers() {
        return this.hibernateTemplate.loadAll(TeamSponsorerDetails.class);
    }

}
