package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.RoleMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class RoleMaster.
 * @see .RoleMaster
 * @author Hibernate Tools
 */
public class RoleMasterDAOImpl {

    private static final Log log = LogFactory.getLog(RoleMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(RoleMaster transientInstance) {
        log.debug("persisting RoleMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(RoleMaster instance) {
        log.debug("attaching dirty RoleMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(RoleMaster instance) {
        log.debug("attaching clean RoleMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(RoleMaster persistentInstance) {
        log.debug("deleting RoleMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public RoleMaster merge(RoleMaster detachedInstance) {
        log.debug("merging RoleMaster instance");
        try {
            RoleMaster result = (RoleMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public RoleMaster findById(java.lang.Long id) {
        log.debug("getting RoleMaster instance with id: " + id);
        try {
            RoleMaster instance = (RoleMaster) sessionFactory.getCurrentSession().get("RoleMaster", id);
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

    public List<RoleMaster> findByExample(RoleMaster instance) {
        log.debug("finding RoleMaster instance by example");
        try {
            List<RoleMaster> results = (List<RoleMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("RoleMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
