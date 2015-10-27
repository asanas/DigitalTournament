package com.digitour.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.client.pojo.PlayerPerformace;
import com.digitour.app.dao.MatchPointDetailsDAO;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.TournamentParticipantTeam;

@Repository
public class MatchPointDetailsDAOImpl implements MatchPointDetailsDAO {

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
        chasingParticipantIds.add(null);
        
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        Disjunction or = Restrictions.disjunction();
        or.add(Restrictions.in("attackParticipantProfileId", chasingParticipantIds))
          .add(Restrictions.isNull("attackParticipantProfileId"));
        
        criteria.add(Restrictions.eq("matchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(or)
                .add(Restrictions.eq("out", true))
                .setProjection(Projections.rowCount());
        return (Long) ((List)this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

    @Override
    public Long getCurrentInningPointsForTheTeam(TournamentMatchDetails tournamentMatchDetails,
            List<TournamentParticipantTeam> defendingParticipatingTeam, Long inning, Long turn) {
        List<Long> chasingParticipantIds = new ArrayList<>();
        for(TournamentParticipantTeam participantTeam: defendingParticipatingTeam) {
            chasingParticipantIds.add(participantTeam.getTournamentParticipantPlayerId());
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.add(Restrictions.eq("matchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.in("attackParticipantProfileId", chasingParticipantIds))
                .add(Restrictions.eq("inningNumber", inning))
                .add(Restrictions.eq("turnNumber", turn))
                .setProjection(Projections.rowCount());
        return (Long) ((List)this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

    @Override
    public List<MatchPointDetails> getTopDefendersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam) {
        List<Long> defenderParticipantIds = new ArrayList<>();
        for(TournamentParticipantTeam defenderProfile: participantTeam) {
            defenderParticipantIds.add(defenderProfile.getTournamentParticipantPlayerId());
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.add(Restrictions.eq("matchId", matchDetails.getTournamentMatchId()))
                .add(Restrictions.in("defenceParticipantProfileId", defenderParticipantIds))
                .add(Restrictions.ge("perTime", 80L))
                .addOrder(Order.desc("perTime"));
        return (List<MatchPointDetails>) this.hibernateTemplate.findByCriteria(criteria);
    }

    @Override
    public List<PlayerPerformace> getTopAttackersListByMatch(TournamentMatchDetails matchDetails,
            List<TournamentParticipantTeam> participantTeam) {
        List<Long> attackerParticipantIds = new ArrayList<>();
        for(TournamentParticipantTeam attackerProfile: participantTeam) {
            attackerParticipantIds.add(attackerProfile.getTournamentParticipantPlayerId());
        }
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchPointDetails.class);
        criteria.setProjection(Projections.projectionList()
                .add(Projections.groupProperty("attackParticipantProfileId"), "tournamentParticipantProfileId")
                .add(Projections.rowCount(), "count"))
                .addOrder(Order.desc("count"))
                .setResultTransformer(Transformers.aliasToBean(PlayerPerformace.class));
        return (List<PlayerPerformace>) this.hibernateTemplate.findByCriteria(criteria);
    }
}
