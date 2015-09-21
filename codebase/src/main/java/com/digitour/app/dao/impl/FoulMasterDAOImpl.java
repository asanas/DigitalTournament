package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.FoulMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class FoulMaster.
 * @see .FoulMaster
 * @author Hibernate Tools
 */
public class FoulMasterDAOImpl {

    private static final Log log = LogFactory.getLog(FoulMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(FoulMaster transientInstance) {
        log.debug("persisting FoulMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(FoulMaster instance) {
        log.debug("attaching dirty FoulMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(FoulMaster instance) {
        log.debug("attaching clean FoulMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(FoulMaster persistentInstance) {
        log.debug("deleting FoulMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public FoulMaster merge(FoulMaster detachedInstance) {
        log.debug("merging FoulMaster instance");
        try {
            FoulMaster result = (FoulMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public FoulMaster findById(java.lang.Long id) {
        log.debug("getting FoulMaster instance with id: " + id);
        try {
            FoulMaster instance = (FoulMaster) sessionFactory.getCurrentSession().get("FoulMaster", id);
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

    public List<FoulMaster> findByExample(FoulMaster instance) {
        log.debug("finding FoulMaster instance by example");
        try {
            List<FoulMaster> results = (List<FoulMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("FoulMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
