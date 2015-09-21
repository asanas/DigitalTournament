package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.TossDetailsMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class TossDetailsMaster.
 * @see .TossDetailsMaster
 * @author Hibernate Tools
 */
public class TossDetailsMasterDAOImpl {

    private static final Log log = LogFactory.getLog(TossDetailsMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(TossDetailsMaster transientInstance) {
        log.debug("persisting TossDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(TossDetailsMaster instance) {
        log.debug("attaching dirty TossDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(TossDetailsMaster instance) {
        log.debug("attaching clean TossDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(TossDetailsMaster persistentInstance) {
        log.debug("deleting TossDetailsMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public TossDetailsMaster merge(TossDetailsMaster detachedInstance) {
        log.debug("merging TossDetailsMaster instance");
        try {
            TossDetailsMaster result = (TossDetailsMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public TossDetailsMaster findById(java.lang.Long id) {
        log.debug("getting TossDetailsMaster instance with id: " + id);
        try {
            TossDetailsMaster instance = (TossDetailsMaster) sessionFactory.getCurrentSession().get("TossDetailsMaster",
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

    public List<TossDetailsMaster> findByExample(TossDetailsMaster instance) {
        log.debug("finding TossDetailsMaster instance by example");
        try {
            List<TossDetailsMaster> results = (List<TossDetailsMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("TossDetailsMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
