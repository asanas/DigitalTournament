package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentParticipantTeamMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentParticipantTeamMaster.
 * @see .TournamentParticipantTeamMaster
 * @author Hibernate Tools
 */
public class TournamentParticipantTeamMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentParticipantTeamMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentParticipantTeamMaster transientInstance) {
        log.debug("persisting TournamentParticipantTeamMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentParticipantTeamMaster instance) {
        log.debug("attaching dirty TournamentParticipantTeamMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentParticipantTeamMaster instance) {
        log.debug("attaching clean TournamentParticipantTeamMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentParticipantTeamMaster persistentInstance) {
        log.debug("deleting TournamentParticipantTeamMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentParticipantTeamMaster merge(TournamentParticipantTeamMaster detachedInstance) {
        log.debug("merging TournamentParticipantTeamMaster instance");
        try {
            TournamentParticipantTeamMaster result = (TournamentParticipantTeamMaster) sessionFactory
                    .getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentParticipantTeamMaster findById(java.lang.Long id) {
        log.debug("getting TournamentParticipantTeamMaster instance with id: " + id);
        try {
            TournamentParticipantTeamMaster instance = (TournamentParticipantTeamMaster) sessionFactory
                    .getCurrentSession().get("TournamentParticipantTeamMaster", id);
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

    public List<TournamentParticipantTeamMaster> findByExample(TournamentParticipantTeamMaster instance) {
        log.debug("finding TournamentParticipantTeamMaster instance by example");
        try {
            List<TournamentParticipantTeamMaster> results = (List<TournamentParticipantTeamMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentParticipantTeamMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
