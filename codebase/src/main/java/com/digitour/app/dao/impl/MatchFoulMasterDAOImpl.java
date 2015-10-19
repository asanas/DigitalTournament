package com.digitour.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.MatchFoulMasterDAO;
import com.digitour.app.db.model.FoulDetails;
import com.digitour.app.db.model.MatchFoulDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

@Repository
public class MatchFoulMasterDAOImpl implements MatchFoulMasterDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
    @Override
    public Long getFoulsCountByInningAndParticipantForMatch(FoulDetails foulDetails, TournamentMatchDetails tournamentMatchDetails,
            Long tournamentPartipantId, Long inning) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchFoulDetails.class);
        criteria.add(Restrictions.eq("tournamentMatchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.eq("foulDetails", foulDetails))
                .add(Restrictions.eq("tournamentParticipantId", tournamentPartipantId))
                .add(Restrictions.eq("inningNumber", inning))
                .setProjection(Projections.rowCount());
        return (Long) ((List)this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

	@Override
	public void save(MatchFoulDetails newMatchFoulDetails) {
		this.hibernateTemplate.saveOrUpdate(newMatchFoulDetails);
	}
    
}