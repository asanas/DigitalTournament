package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentMaster.
 * @see .TournamentMaster
 * @author Hibernate Tools
 */
public class TournamentMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentMaster transientInstance) {
        log.debug("persisting TournamentMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentMaster instance) {
        log.debug("attaching dirty TournamentMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentMaster instance) {
        log.debug("attaching clean TournamentMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentMaster persistentInstance) {
        log.debug("deleting TournamentMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentMaster merge(TournamentMaster detachedInstance) {
        log.debug("merging TournamentMaster instance");
        try {
            TournamentMaster result = (TournamentMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentMaster findById(java.lang.Long id) {
        log.debug("getting TournamentMaster instance with id: " + id);
        try {
            TournamentMaster instance = (TournamentMaster) sessionFactory.getCurrentSession().get("TournamentMaster",
                    id);
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

    public List<TournamentMaster> findByExample(TournamentMaster instance) {
        log.debug("finding TournamentMaster instance by example");
        try {
            List<TournamentMaster> results = (List<TournamentMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("TournamentMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
