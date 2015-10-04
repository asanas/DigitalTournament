package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TeamDAO;
import com.digitour.app.db.model.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

    private static final Log log = LogFactory.getLog(TeamDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public Team save(Team transientInstance) {
        log.debug("persisting TeamMaster instance");
        try {
            hibernateTemplate.save(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
        return transientInstance;
    }

    @Override
    public List<Team> getAll() {
        return hibernateTemplate.loadAll(Team.class);
    }

	@Override
	public Team getById(Long teamId) {
		return hibernateTemplate.get(Team.class, teamId);
	}
}
