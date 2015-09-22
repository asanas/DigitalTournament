package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.model.CityMaster;

@Repository
public class CityMasterDAOImpl implements CityMasterDAO{

    private static final Log log = LogFactory.getLog(CityMasterDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public List<CityMaster> getAll() {
        log.debug("Loading all city names");
        return hibernateTemplate.loadAll(CityMaster.class);
    }
    
    /*public void save(CityMaster transientInstance) {
        log.debug("persisting CityMaster instance");
        try {
            hibernateTemplate.save(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(CityMaster instance) {
        log.debug("attaching dirty CityMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(CityMaster instance) {
        log.debug("attaching clean CityMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(CityMaster persistentInstance) {
        log.debug("deleting CityMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CityMaster merge(CityMaster detachedInstance) {
        log.debug("merging CityMaster instance");
        try {
            CityMaster result = (CityMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public CityMaster findById(java.lang.Long id) {
        log.debug("getting CityMaster instance with id: " + id);
        try {
            CityMaster instance = (CityMaster) sessionFactory.getCurrentSession().get("CityMaster", id);
            if (instance == null) {
                log.debug("get successful, no instance found");
            } else {
                log.debug("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }

    public List<CityMaster> findByExample(CityMaster instance) {
        log.debug("finding CityMaster instance by example");
        try {
            List<CityMaster> results = (List<CityMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("CityMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }*/
}
