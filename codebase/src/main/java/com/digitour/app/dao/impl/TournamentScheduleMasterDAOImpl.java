package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentScheduleMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentScheduleMaster.
 * @see .TournamentScheduleMaster
 * @author Hibernate Tools
 */
public class TournamentScheduleMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentScheduleMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentScheduleMaster transientInstance) {
        log.debug("persisting TournamentScheduleMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentScheduleMaster instance) {
        log.debug("attaching dirty TournamentScheduleMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentScheduleMaster instance) {
        log.debug("attaching clean TournamentScheduleMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentScheduleMaster persistentInstance) {
        log.debug("deleting TournamentScheduleMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentScheduleMaster merge(TournamentScheduleMaster detachedInstance) {
        log.debug("merging TournamentScheduleMaster instance");
        try {
            TournamentScheduleMaster result = (TournamentScheduleMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentScheduleMaster findById(java.lang.Long id) {
        log.debug("getting TournamentScheduleMaster instance with id: " + id);
        try {
            TournamentScheduleMaster instance = (TournamentScheduleMaster) sessionFactory.getCurrentSession()
                    .get("TournamentScheduleMaster", id);
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

    public List<TournamentScheduleMaster> findByExample(TournamentScheduleMaster instance) {
        log.debug("finding TournamentScheduleMaster instance by example");
        try {
            List<TournamentScheduleMaster> results = (List<TournamentScheduleMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("TournamentScheduleMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
