package com.digitour.app.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.db.model.MatchTurnDetails;

@Repository
public class MatchTurnDAOImpl implements MatchTurnDAO {

    @Autowired
    HibernateTemplate hibernateTemplate;
    
    @Override
    public MatchTurnDetails getInningDetailsByMatchInningAndTurnNumber(Long matchId, Long inning, Long turn) {
        DetachedCriteria criteria = DetachedCriteria.forClass(MatchTurnDetails.class);
        criteria.add(Restrictions.eq("matchId", matchId))
                .add(Restrictions.eq("inningNumber", inning))
                .add(Restrictions.eq("turnNumber", turn));
        return ((List<MatchTurnDetails>) this.hibernateTemplate.findByCriteria(criteria)).get(0);
    }

    @Override
    public void save(MatchTurnDetails matchTurn) {
        this.hibernateTemplate.saveOrUpdate(matchTurn);
    }

}
