package com.digitour.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

@Repository
public class MatchTurnDAOImpl implements MatchTurnDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    public MatchTurnDetails getInningDetailsByMatchInningAndTurnNumber(TournamentMatchDetails matchDetails, Long inning, Long turn) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchTurnDetails.class);
        criteria.add(Restrictions.eq("tournamentMatchDetails", matchDetails))
                .add(Restrictions.eq("inningNumber", inning))
                .add(Restrictions.eq("turnNumber", turn));
        return ((List<MatchTurnDetails>) this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

    @Override
    @Transactional
    public void save(MatchTurnDetails matchTurn) {
        this.hibernateTemplate.saveOrUpdate(matchTurn);
    }

}
