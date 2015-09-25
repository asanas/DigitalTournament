package com.digitour.app.dao.impl;
// Generated 19 Sep, 2015 10:42:10 PM by Hibernate Tools 4.3.1

import java.util.List;

import javax.naming.InitialContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.digitour.app.model.example.MajorSkill;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class MajorSkill.
 * @see .MajorSkill
 * @author Hibernate Tools
 */
public class MajorSkillDAOImpl {

    private static final Log log = LogFactory.getLog(MajorSkillDAOImpl.class);

    private final SessionFactory sessionFactory = getSessionFactory();

    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        } catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }

    public void persist(MajorSkill transientInstance) {
        log.debug("persisting MajorSkill instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    public void attachDirty(MajorSkill instance) {
        log.debug("attaching dirty MajorSkill instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void attachClean(MajorSkill instance) {
        log.debug("attaching clean MajorSkill instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

    public void delete(MajorSkill persistentInstance) {
        log.debug("deleting MajorSkill instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }

    public MajorSkill merge(MajorSkill detachedInstance) {
        log.debug("merging MajorSkill instance");
        try {
            MajorSkill result = (MajorSkill) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public MajorSkill findById(java.lang.Long id) {
        log.debug("getting MajorSkill instance with id: " + id);
        try {
            MajorSkill instance = (MajorSkill) sessionFactory.getCurrentSession().get("MajorSkill", id);
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

    public List<MajorSkill> findByExample(MajorSkill instance) {
        log.debug("finding MajorSkill instance by example");
        try {
            List<MajorSkill> results = (List<MajorSkill>) sessionFactory.getCurrentSession()
                    .createCriteria("MajorSkill").add(create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }
}
