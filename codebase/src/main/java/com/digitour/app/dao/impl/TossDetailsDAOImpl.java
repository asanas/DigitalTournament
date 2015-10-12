package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TossDetailsDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.TournamentMatchDetails;

@Repository
public class TossDetailsDAOImpl implements TossDetailsDAO {

    private static final Log log = LogFactory.getLog(TossDetailsDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public void save(MatchTossDetails matchToss) {
		this.hibernateTemplate.saveOrUpdate(matchToss);
	}

    @Override
    public MatchTossDetails getTossDetailsByMatch(TournamentMatchDetails tournamentMatchDetails) {
        MatchTossDetails tossDetails  = new MatchTossDetails();
        tossDetails.setTournamentMatchDetails(tournamentMatchDetails);
        return ((List<MatchTossDetails>)(this.hibernateTemplate.findByExample(tossDetails))).get(0);
    }
    
    
}
