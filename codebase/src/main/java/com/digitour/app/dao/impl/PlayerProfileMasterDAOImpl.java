package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.PlayerProfileMasterDAO;
import com.digitour.app.db.model.PlayerProfile;

@Repository
public class PlayerProfileMasterDAOImpl implements PlayerProfileMasterDAO{

    private static final Log log = LogFactory.getLog(PlayerProfileMasterDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void save(PlayerProfile transientInstance) {
        log.debug("persisting PlayerProfileMaster instance");
        try {
            hibernateTemplate.save(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
}
