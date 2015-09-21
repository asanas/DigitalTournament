package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.PlayerProfileMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PlayerProfileMaster.
 * @see .PlayerProfileMaster
 * @author Hibernate Tools
 */
public class PlayerProfileMasterDAOImpl {

    private static final Log log = LogFactory.getLog(PlayerProfileMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(PlayerProfileMaster transientInstance) {
        log.debug("persisting PlayerProfileMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(PlayerProfileMaster instance) {
        log.debug("attaching dirty PlayerProfileMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(PlayerProfileMaster instance) {
        log.debug("attaching clean PlayerProfileMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(PlayerProfileMaster persistentInstance) {
        log.debug("deleting PlayerProfileMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public PlayerProfileMaster merge(PlayerProfileMaster detachedInstance) {
        log.debug("merging PlayerProfileMaster instance");
        try {
            PlayerProfileMaster result = (PlayerProfileMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public PlayerProfileMaster findById(java.lang.Long id) {
        log.debug("getting PlayerProfileMaster instance with id: " + id);
        try {
            PlayerProfileMaster instance = (PlayerProfileMaster) sessionFactory.getCurrentSession()
                    .get("PlayerProfileMaster", id);
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

    public List<PlayerProfileMaster> findByExample(PlayerProfileMaster instance) {
        log.debug("finding PlayerProfileMaster instance by example");
        try {
            List<PlayerProfileMaster> results = (List<PlayerProfileMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("PlayerProfileMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
