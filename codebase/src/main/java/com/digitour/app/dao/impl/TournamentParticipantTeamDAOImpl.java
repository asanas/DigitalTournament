package com.digitour.app.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.digitour.app.dao.TournamentParticipantTeamDAO;
import com.digitour.app.db.model.MatchTossDetails;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.TournamentParticipantTeam;

@Repository
public class TournamentParticipantTeamDAOImpl implements TournamentParticipantTeamDAO {

    private static final Log log = LogFactory.getLog(TournamentParticipantTeamDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    
    @Override
    @Transactional
    public void save(TournamentParticipantTeam tourTeam) {
        this.hibernateTemplate.saveOrUpdate(tourTeam);
    }


    @Override
    public List<TournamentParticipantTeam> getByTournamentParticipantOrderByChaseNumber(TournamentParticipant tournamentParticipant1) {
        DetachedCriteria criteria = DetachedCriteria.forClass(TournamentParticipantTeam.class);
        criteria.add(Restrictions.eq("tournamentPartipantId", tournamentParticipant1.getTourParticipantId()))
                .addOrder(Order.asc("playerChaseNumber"));
        return (List<TournamentParticipantTeam>) this.hibernateTemplate.findByCriteria(criteria);
    }


    @Override
    public TournamentParticipantTeam getById(Long tournamentParticipantProfileId) {
        return this.hibernateTemplate.load(TournamentParticipantTeam.class, tournamentParticipantProfileId);
    }


    @Override
    public TournamentParticipantTeam getByPlayerProfileAndTournamentParticipant(PlayerProfile playerProfile,
            TournamentParticipant tournamentParticipant) {
    	TournamentParticipantTeam participantProfile = null;
        DetachedCriteria criteria = DetachedCriteria.forClass(TournamentParticipantTeam.class);
        criteria.add(Restrictions.eq("playerProfileId", playerProfile.getPlayerProfileId()))
                .add(Restrictions.eq("tournamentPartipantId", tournamentParticipant.getTourParticipantId()));
        List<TournamentParticipantTeam> participantProfileList = (List<TournamentParticipantTeam>) this.hibernateTemplate.findByCriteria(criteria);
        if(!CollectionUtils.isEmpty(participantProfileList)) {
        	participantProfile = participantProfileList.get(0);
        }
        return participantProfile;
    }

}
