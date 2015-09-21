package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.SymbolMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SymbolMaster.
 * @see .SymbolMaster
 * @author Hibernate Tools
 */
public class SymbolMasterDAOImpl {

    private static final Log log = LogFactory.getLog(SymbolMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(SymbolMaster transientInstance) {
        log.debug("persisting SymbolMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(SymbolMaster instance) {
        log.debug("attaching dirty SymbolMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(SymbolMaster instance) {
        log.debug("attaching clean SymbolMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(SymbolMaster persistentInstance) {
        log.debug("deleting SymbolMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public SymbolMaster merge(SymbolMaster detachedInstance) {
        log.debug("merging SymbolMaster instance");
        try {
            SymbolMaster result = (SymbolMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public SymbolMaster findById(java.lang.Long id) {
        log.debug("getting SymbolMaster instance with id: " + id);
        try {
            SymbolMaster instance = (SymbolMaster) sessionFactory.getCurrentSession().get("SymbolMaster", id);
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

    public List<SymbolMaster> findByExample(SymbolMaster instance) {
        log.debug("finding SymbolMaster instance by example");
        try {
            List<SymbolMaster> results = (List<SymbolMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("SymbolMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
