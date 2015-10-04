package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.db.model.MatchPointDetails;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MatchPointMaster.
 * @see .MatchPointMaster
 * @author Hibernate Tools
 */
public class MatchPointMasterDAOImpl {

    private static final Log log = LogFactory.getLog(MatchPointMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(MatchPointDetails transientInstance) {
        log.debug("persisting MatchPointMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(MatchPointDetails instance) {
        log.debug("attaching dirty MatchPointMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(MatchPointDetails instance) {
        log.debug("attaching clean MatchPointMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(MatchPointDetails persistentInstance) {
        log.debug("deleting MatchPointMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public MatchPointDetails merge(MatchPointDetails detachedInstance) {
        log.debug("merging MatchPointMaster instance");
        try {
            MatchPointDetails result = (MatchPointDetails) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public MatchPointDetails findById(java.lang.Long id) {
        log.debug("getting MatchPointMaster instance with id: " + id);
        try {
            MatchPointDetails instance = (MatchPointDetails) sessionFactory.getCurrentSession().get("MatchPointMaster",
                    id);
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

    public List<MatchPointDetails> findByExample(MatchPointDetails instance) {
        log.debug("finding MatchPointMaster instance by example");
        try {
            List<MatchPointDetails> results = (List<MatchPointDetails>) sessionFactory.getCurrentSession()
                    .createCriteria("MatchPointMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
