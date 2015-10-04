package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TournamentParticipantMasterDAO;
import com.digitour.app.db.model.TournamentParticipant;

@Repository
public class TournamentParticipantMasterDAOImpl implements TournamentParticipantMasterDAO {

    private static final Log log = LogFactory.getLog(TournamentParticipantMasterDAOImpl.class);

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    @Transactional
    public void save(TournamentParticipant tourPartipant) {
        this.hibernateTemplate.saveOrUpdate(tourPartipant);
    }

}
