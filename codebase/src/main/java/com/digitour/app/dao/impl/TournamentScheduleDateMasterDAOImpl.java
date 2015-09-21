package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TournamentScheduleDateMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TournamentScheduleDateMaster.
 * @see .TournamentScheduleDateMaster
 * @author Hibernate Tools
 */
public class TournamentScheduleDateMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TournamentScheduleDateMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentScheduleDateMaster transientInstance) {
        log.debug("persisting TournamentScheduleDateMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentScheduleDateMaster instance) {
        log.debug("attaching dirty TournamentScheduleDateMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentScheduleDateMaster instance) {
        log.debug("attaching clean TournamentScheduleDateMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentScheduleDateMaster persistentInstance) {
        log.debug("deleting TournamentScheduleDateMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentScheduleDateMaster merge(TournamentScheduleDateMaster detachedInstance) {
        log.debug("merging TournamentScheduleDateMaster instance");
        try {
            TournamentScheduleDateMaster result = (TournamentScheduleDateMaster) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentScheduleDateMaster findById(java.lang.Long id) {
        log.debug("getting TournamentScheduleDateMaster instance with id: " + id);
        try {
            TournamentScheduleDateMaster instance = (TournamentScheduleDateMaster) sessionFactory.getCurrentSession()
                    .get("TournamentScheduleDateMaster", id);
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

    public List<TournamentScheduleDateMaster> findByExample(TournamentScheduleDateMaster instance) {
        log.debug("finding TournamentScheduleDateMaster instance by example");
        try {
            List<TournamentScheduleDateMaster> results = (List<TournamentScheduleDateMaster>) sessionFactory
                    .getCurrentSession().createCriteria("TournamentScheduleDateMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
