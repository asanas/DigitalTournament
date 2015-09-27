package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.db.model.TournamentOfficial;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class OfficialMaster.
 * @see .OfficialMaster
 * @author Hibernate Tools
 */
public class OfficialMasterDAOImpl {

    private static final Log log = LogFactory.getLog(OfficialMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TournamentOfficial transientInstance) {
        log.debug("persisting OfficialMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TournamentOfficial instance) {
        log.debug("attaching dirty OfficialMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TournamentOfficial instance) {
        log.debug("attaching clean OfficialMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TournamentOfficial persistentInstance) {
        log.debug("deleting OfficialMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TournamentOfficial merge(TournamentOfficial detachedInstance) {
        log.debug("merging OfficialMaster instance");
        try {
            TournamentOfficial result = (TournamentOfficial) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TournamentOfficial findById(java.lang.Long id) {
        log.debug("getting OfficialMaster instance with id: " + id);
        try {
            TournamentOfficial instance = (TournamentOfficial) sessionFactory.getCurrentSession().get("OfficialMaster", id);
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

    public List<TournamentOfficial> findByExample(TournamentOfficial instance) {
        log.debug("finding OfficialMaster instance by example");
        try {
            List<TournamentOfficial> results = (List<TournamentOfficial>) sessionFactory.getCurrentSession()
                    .createCriteria("OfficialMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
