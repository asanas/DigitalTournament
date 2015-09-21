package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.CountryMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CountryMaster.
 * @see .CountryMaster
 * @author Hibernate Tools
 */
public class CountryMasterDAOImpl {

    private static final Log log = LogFactory.getLog(CountryMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(CountryMaster transientInstance) {
        log.debug("persisting CountryMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(CountryMaster instance) {
        log.debug("attaching dirty CountryMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(CountryMaster instance) {
        log.debug("attaching clean CountryMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(CountryMaster persistentInstance) {
        log.debug("deleting CountryMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public CountryMaster merge(CountryMaster detachedInstance) {
        log.debug("merging CountryMaster instance");
        try {
            CountryMaster result = (CountryMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public CountryMaster findById(java.lang.Long id) {
        log.debug("getting CountryMaster instance with id: " + id);
        try {
            CountryMaster instance = (CountryMaster) sessionFactory.getCurrentSession().get("CountryMaster", id);
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

    public List<CountryMaster> findByExample(CountryMaster instance) {
        log.debug("finding CountryMaster instance by example");
        try {
            List<CountryMaster> results = (List<CountryMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("CountryMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
