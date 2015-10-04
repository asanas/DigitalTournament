package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TournamentDAO;
import com.digitour.app.db.model.Tournament;

@Repository
public class TournamentDAOImpl implements TournamentDAO {

    private static final Log log = LogFactory.getLog(TournamentDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    @Transactional
    public void save(Tournament transientInstance) {
        log.debug("persisting Tournament instance");
        try {
            hibernateTemplate.saveOrUpdate(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

}
