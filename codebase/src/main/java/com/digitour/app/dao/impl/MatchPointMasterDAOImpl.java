package com.digitour.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.MatchPointMasterDAO;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipantTeam;

@Repository
public class MatchPointMasterDAOImpl implements MatchPointMasterDAO{

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public List<MatchPointDetails> getMatchPointsByInningTurnAndDefender(TournamentMatchDetails tournamentMatchDetails, Long tournamentParticipantPlayerId,
            Long inning, Long turn) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.add(Restrictions.eq("matchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.eq("defenceParticipantProfileId", tournamentParticipantPlayerId))
                .add(Restrictions.eq("inningNumber", inning))
                .add(Restrictions.eq("turnNumber", turn));
        return (List<MatchPointDetails>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Transactional
	@Override
	public void save(MatchPointDetails matchPoint) {
		this.hibernateTemplate.saveOrUpdate(matchPoint);
	}

    @Override
    public Long getMaxRunTimeByMatchInningAndTurn(TournamentMatchDetails tournamentMatchDetails, Long inning, Long turn) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.add(Restrictions.eq("matchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.eq("inningNumber", inning))
                .add(Restrictions.eq("turnNumber", turn))
                .setProjection(Projections.max("runTime"));
        return (Long) ((List)this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

	@Override
	public Long getTotalMatchPointsForTheTeam(TournamentMatchDetails tournamentMatchDetails,
			List<TournamentParticipantTeam> chasingParticipantTeam) {
		List<Long> chasingParticipantIds = new ArrayList<>();
		for(TournamentParticipantTeam participantTeam: chasingParticipantTeam) {
			chasingParticipantIds.add(participantTeam.getTournamentParticipantPlayerId());
		}
		DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.add(Restrictions.eq("matchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.in("attackParticipantProfileId", chasingParticipantIds))
                .setProjection(Projections.rowCount());
        return (Long) ((List)this.hibernateTemplate.findByCriteria(criteria)).get(0);
	}
}
