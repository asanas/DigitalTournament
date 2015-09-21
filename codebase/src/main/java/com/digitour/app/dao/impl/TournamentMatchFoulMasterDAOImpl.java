package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentMatchFoulMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentMatchFoulMaster.
 * @see .TournamentMatchFoulMaster
 * @author Hibernate Tools
 */
public class TournamentMatchFoulMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentMatchFoulMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentMatchFoulMaster transientInstance) {
        log.debug("persisting TournamentMatchFoulMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentMatchFoulMaster instance) {
        log.debug("attaching dirty TournamentMatchFoulMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentMatchFoulMaster instance) {
        log.debug("attaching clean TournamentMatchFoulMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentMatchFoulMaster persistentInstance) {
        log.debug("deleting TournamentMatchFoulMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentMatchFoulMaster merge(TournamentMatchFoulMaster detachedInstance) {
        log.debug("merging TournamentMatchFoulMaster instance");
        try {
            TournamentMatchFoulMaster result = (TournamentMatchFoulMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentMatchFoulMaster findById(java.lang.Long id) {
        log.debug("getting TournamentMatchFoulMaster instance with id: " + id);
        try {
            TournamentMatchFoulMaster instance = (TournamentMatchFoulMaster) sessionFactory.getCurrentSession()
                    .get("TournamentMatchFoulMaster", id);
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

    public List<TournamentMatchFoulMaster> findByExample(TournamentMatchFoulMaster instance) {
        log.debug("finding TournamentMatchFoulMaster instance by example");
        try {
            List<TournamentMatchFoulMaster> results = (List<TournamentMatchFoulMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentMatchFoulMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}