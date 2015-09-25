package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.example.TournamentGroupDetailsMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentGroupDetailsMaster.
 * @see .TournamentGroupDetailsMaster
 * @author Hibernate Tools
 */
public class TournamentGroupDetailsMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentGroupDetailsMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentGroupDetailsMaster transientInstance) {
        log.debug("persisting TournamentGroupDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentGroupDetailsMaster instance) {
        log.debug("attaching dirty TournamentGroupDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentGroupDetailsMaster instance) {
        log.debug("attaching clean TournamentGroupDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentGroupDetailsMaster persistentInstance) {
        log.debug("deleting TournamentGroupDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentGroupDetailsMaster merge(TournamentGroupDetailsMaster detachedInstance) {
        log.debug("merging TournamentGroupDetailsMaster instance");
        try {
            TournamentGroupDetailsMaster result = (TournamentGroupDetailsMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentGroupDetailsMaster findById(java.lang.Long id) {
        log.debug("getting TournamentGroupDetailsMaster instance with id: " + id);
        try {
            TournamentGroupDetailsMaster instance = (TournamentGroupDetailsMaster) sessionFactory.getCurrentSession()
                    .get("TournamentGroupDetailsMaster", id);
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

    public List<TournamentGroupDetailsMaster> findByExample(TournamentGroupDetailsMaster instance) {
        log.debug("finding TournamentGroupDetailsMaster instance by example");
        try {
            List<TournamentGroupDetailsMaster> results = (List<TournamentGroupDetailsMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentGroupDetailsMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
