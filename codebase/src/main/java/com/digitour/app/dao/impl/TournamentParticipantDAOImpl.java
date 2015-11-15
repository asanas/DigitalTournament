package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;

@Repository
public class TournamentParticipantDAOImpl implements TournamentParticipantDAO {

    private static final Log log = LogFactory.getLog(TournamentParticipantDAOImpl.class);

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    @Transactional
    public void save(TournamentParticipant tourPartipant) {
        this.hibernateTemplate.saveOrUpdate(tourPartipant);
    }

    @Override
    public TournamentParticipant getById(Long teamParticipantId) {
        return this.hibernateTemplate.load(TournamentParticipant.class, teamParticipantId);
    }

    @Override
    public TournamentParticipant getByTeamAndTournament(Team team, Long tournamentId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(TournamentParticipant.class);
        criteria.add(Restrictions.eq("teamId", team.getTeamId()))
                .add(Restrictions.eq("tournamentId", tournamentId));
        return ((List<TournamentParticipant>) this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

    @Override
    public List<TournamentParticipant> getByTournament(Tournament tournament) {
        DetachedCriteria criteria = DetachedCriteria.forClass(TournamentParticipant.class);
        criteria.add(Restrictions.eq("tournamentId", tournament.getTournamentId()));
        return ((List<TournamentParticipant>) this.hibernateTemplate.findByCriteria(criteria));
    }

}
