package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.PlayerProfileDAO;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.support.enums.Role;

@Repository
public class PlayerProfileDAOImpl implements PlayerProfileDAO{

    private static final Log log = LogFactory.getLog(PlayerProfileDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Transactional
    public void save(PlayerProfile transientInstance) {
        log.debug("persisting PlayerProfileMaster instance");
        try {
            hibernateTemplate.save(transientInstance);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }

    @Override
    public PlayerProfile getById(Long playerProfileId) {
        return this.hibernateTemplate.load(PlayerProfile.class, playerProfileId);
    }

    @Override
    public List<PlayerProfile> getCoachManagerByTeam(Team team) {
        DetachedCriteria criteria = DetachedCriteria.forClass(PlayerProfile.class);
        Criterion criterion = Restrictions.or(Restrictions.eq("role", Role.MANAGER), Restrictions.eq("role", Role.COACH));
        criteria.add(criterion)
                .add(Restrictions.eq("team", team));
        return ((List<PlayerProfile>) this.hibernateTemplate.findByCriteria(criteria));
    }
}
