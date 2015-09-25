package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.example.TournamentParticipantPointsMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentParticipantPointsMaster.
 * @see .TournamentParticipantPointsMaster
 * @author Hibernate Tools
 */
public class TournamentParticipantPointsMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentParticipantPointsMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentParticipantPointsMaster transientInstance) {
        log.debug("persisting TournamentParticipantPointsMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentParticipantPointsMaster instance) {
        log.debug("attaching dirty TournamentParticipantPointsMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentParticipantPointsMaster instance) {
        log.debug("attaching clean TournamentParticipantPointsMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentParticipantPointsMaster persistentInstance) {
        log.debug("deleting TournamentParticipantPointsMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentParticipantPointsMaster merge(TournamentParticipantPointsMaster detachedInstance) {
        log.debug("merging TournamentParticipantPointsMaster instance");
        try {
            TournamentParticipantPointsMaster result = (TournamentParticipantPointsMaster) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentParticipantPointsMaster findById(java.lang.Long id) {
        log.debug("getting TournamentParticipantPointsMaster instance with id: " + id);
        try {
            TournamentParticipantPointsMaster instance = (TournamentParticipantPointsMaster) sessionFactory
                    .getCurrentSession().get("TournamentParticipantPointsMaster", id);
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

    public List<TournamentParticipantPointsMaster> findByExample(TournamentParticipantPointsMaster instance) {
        log.debug("finding TournamentParticipantPointsMaster instance by example");
        try {
            List<TournamentParticipantPointsMaster> results = (List<TournamentParticipantPointsMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentParticipantPointsMaster").add(create(instance))
                    .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
