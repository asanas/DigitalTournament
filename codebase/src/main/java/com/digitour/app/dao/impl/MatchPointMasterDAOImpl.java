package com.digitour.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.MatchPointMasterDAO;
import com.digitour.app.db.model.MatchPointDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

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
}
