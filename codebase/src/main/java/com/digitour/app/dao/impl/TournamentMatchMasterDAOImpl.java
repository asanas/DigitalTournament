package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentMatchMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentMatchMaster.
 * @see .TournamentMatchMaster
 * @author Hibernate Tools
 */
public class TournamentMatchMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentMatchMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentMatchMaster transientInstance) {
        log.debug("persisting TournamentMatchMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentMatchMaster instance) {
        log.debug("attaching dirty TournamentMatchMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentMatchMaster instance) {
        log.debug("attaching clean TournamentMatchMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentMatchMaster persistentInstance) {
        log.debug("deleting TournamentMatchMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentMatchMaster merge(TournamentMatchMaster detachedInstance) {
        log.debug("merging TournamentMatchMaster instance");
        try {
            TournamentMatchMaster result = (TournamentMatchMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentMatchMaster findById(java.lang.Long id) {
        log.debug("getting TournamentMatchMaster instance with id: " + id);
        try {
            TournamentMatchMaster instance = (TournamentMatchMaster) sessionFactory.getCurrentSession()
                    .get("TournamentMatchMaster", id);
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

    public List<TournamentMatchMaster> findByExample(TournamentMatchMaster instance) {
        log.debug("finding TournamentMatchMaster instance by example");
        try {
            List<TournamentMatchMaster> results = (List<TournamentMatchMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("TournamentMatchMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
