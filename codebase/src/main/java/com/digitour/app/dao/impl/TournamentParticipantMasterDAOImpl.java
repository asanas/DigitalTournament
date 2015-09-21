package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentParticipantMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentParticipantMaster.
 * @see .TournamentParticipantMaster
 * @author Hibernate Tools
 */
public class TournamentParticipantMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentParticipantMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentParticipantMaster transientInstance) {
        log.debug("persisting TournamentParticipantMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentParticipantMaster instance) {
        log.debug("attaching dirty TournamentParticipantMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentParticipantMaster instance) {
        log.debug("attaching clean TournamentParticipantMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentParticipantMaster persistentInstance) {
        log.debug("deleting TournamentParticipantMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentParticipantMaster merge(TournamentParticipantMaster detachedInstance) {
        log.debug("merging TournamentParticipantMaster instance");
        try {
            TournamentParticipantMaster result = (TournamentParticipantMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentParticipantMaster findById(java.lang.Long id) {
        log.debug("getting TournamentParticipantMaster instance with id: " + id);
        try {
            TournamentParticipantMaster instance = (TournamentParticipantMaster) sessionFactory.getCurrentSession()
                    .get("TournamentParticipantMaster", id);
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

    public List<TournamentParticipantMaster> findByExample(TournamentParticipantMaster instance) {
        log.debug("finding TournamentParticipantMaster instance by example");
        try {
            List<TournamentParticipantMaster> results = (List<TournamentParticipantMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentParticipantMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
