package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TeamMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TeamMaster.
 * @see .TeamMaster
 * @author Hibernate Tools
 */
public class TeamMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TeamMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TeamMaster transientInstance) {
        log.debug("persisting TeamMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TeamMaster instance) {
        log.debug("attaching dirty TeamMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TeamMaster instance) {
        log.debug("attaching clean TeamMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TeamMaster persistentInstance) {
        log.debug("deleting TeamMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TeamMaster merge(TeamMaster detachedInstance) {
        log.debug("merging TeamMaster instance");
        try {
            TeamMaster result = (TeamMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TeamMaster findById(java.lang.Long id) {
        log.debug("getting TeamMaster instance with id: " + id);
        try {
            TeamMaster instance = (TeamMaster) sessionFactory.getCurrentSession().get("TeamMaster", id);
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

    public List<TeamMaster> findByExample(TeamMaster instance) {
        log.debug("finding TeamMaster instance by example");
        try {
            List<TeamMaster> results = (List<TeamMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("TeamMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
