package com.digitour.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.digitour.app.dao.MatchFoulMasterDAO;
import com.digitour.app.db.model.FoulDetails;
import com.digitour.app.db.model.MatchFoulDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

@Repository
public class MatchFoulMasterDAOImpl implements MatchFoulMasterDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
    @Override
    public Long getFoulsCountParticipantForMatch(FoulDetails foulDetails, TournamentMatchDetails tournamentMatchDetails,
            Long tournamentPartipantId, Long inning) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchFoulDetails.class);
        criteria.add(Restrictions.eq("tournamentMatchId", tournamentMatchDetails.getTournamentMatchId()))
                .add(Restrictions.eq("foulDetails", foulDetails))
                .add(Restrictions.eq("tournamentParticipantId", tournamentPartipantId))
                .setProjection(Projections.rowCount());
                
        if(null != inning) {
            criteria.add(Restrictions.eq("inningNumber", inning));
        }
        Long foulCount = 0L;
        List<Long> lstTotalFoulCount = ((List)this.hibernateTemplate.findByCriteria(criteria));
        if(!CollectionUtils.isEmpty(lstTotalFoulCount)) {
        	foulCount = lstTotalFoulCount.get(0);
        }
        return foulCount;
    }

	@Override
	@Transactional
	public void save(MatchFoulDetails newMatchFoulDetails) {
		this.hibernateTemplate.saveOrUpdate(newMatchFoulDetails);
	}

    @Override
    @Transactional
    public void removeFoulForMatch(MatchFoulDetails matchFoulDetails) {
        List<MatchFoulDetails> matchFouls = this.hibernateTemplate.findByExample(matchFoulDetails);
        if(!CollectionUtils.isEmpty(matchFouls)) {
            this.hibernateTemplate.delete(matchFouls.get(0));
        }
    }

}