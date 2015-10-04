package com.digitour.app.dao.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TournamentParticipantTeamMasterDAO;
import com.digitour.app.db.model.TournamentParticipantTeam;

@Repository
public class TournamentParticipantTeamMasterDAOImpl implements TournamentParticipantTeamMasterDAO {

    private static final Log log = LogFactory.getLog(TournamentParticipantTeamMasterDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    
	@Override
	@Transactional
	public void save(TournamentParticipantTeam tourTeam) {
		this.hibernateTemplate.saveOrUpdate(tourTeam);
	}

    
}
