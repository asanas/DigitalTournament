package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.example.TournamentMatchResultMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentMatchResultMaster.
 * @see .TournamentMatchResultMaster
 * @author Hibernate Tools
 */
public class TournamentMatchResultMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentMatchResultMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentMatchResultMaster transientInstance) {
        log.debug("persisting TournamentMatchResultMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentMatchResultMaster instance) {
        log.debug("attaching dirty TournamentMatchResultMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentMatchResultMaster instance) {
        log.debug("attaching clean TournamentMatchResultMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentMatchResultMaster persistentInstance) {
        log.debug("deleting TournamentMatchResultMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentMatchResultMaster merge(TournamentMatchResultMaster detachedInstance) {
        log.debug("merging TournamentMatchResultMaster instance");
        try {
            TournamentMatchResultMaster result = (TournamentMatchResultMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentMatchResultMaster findById(java.lang.Long id) {
        log.debug("getting TournamentMatchResultMaster instance with id: " + id);
        try {
            TournamentMatchResultMaster instance = (TournamentMatchResultMaster) sessionFactory.getCurrentSession()
                    .get("TournamentMatchResultMaster", id);
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

    public List<TournamentMatchResultMaster> findByExample(TournamentMatchResultMaster instance) {
        log.debug("finding TournamentMatchResultMaster instance by example");
        try {
            List<TournamentMatchResultMaster> results = (List<TournamentMatchResultMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentMatchResultMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
