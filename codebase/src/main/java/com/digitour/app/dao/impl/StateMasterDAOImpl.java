package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.StateMaster;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class StateMaster.
 * @see .StateMaster
 * @author Hibernate Tools
 */
public class StateMasterDAOImpl {

    private static final Log log = LogFactory.getLog(StateMasterDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(StateMaster transientInstance) {
        log.debug("persisting StateMaster instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(StateMaster instance) {
        log.debug("attaching dirty StateMaster instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(StateMaster instance) {
        log.debug("attaching clean StateMaster instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(StateMaster persistentInstance) {
        log.debug("deleting StateMaster instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public StateMaster merge(StateMaster detachedInstance) {
        log.debug("merging StateMaster instance");
        try {
            StateMaster result = (StateMaster) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public StateMaster findById(java.lang.Long id) {
        log.debug("getting StateMaster instance with id: " + id);
        try {
            StateMaster instance = (StateMaster) sessionFactory.getCurrentSession().get("StateMaster", id);
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

    public List<StateMaster> findByExample(StateMaster instance) {
        log.debug("finding StateMaster instance by example");
        try {
            List<StateMaster> results = (List<StateMaster>) sessionFactory.getCurrentSession()
                    .createCriteria("StateMaster").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
