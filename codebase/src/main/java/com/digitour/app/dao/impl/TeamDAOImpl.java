package com.digitour.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.digitour.app.dao.TeamDAO;
import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.db.model.support.enums.TeamType;

@Repository
public class TeamDAOImpl implements TeamDAO {

    private static final Log log = LogFactory.getLog(TeamDAOImpl.class);

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Autowired
    private TournamentParticipantDAO tourParticipantsDAO;
    
    @Transactional
    public Team save(Team team) {
        log.debug("persisting TeamMaster instance");
        try {
            hibernateTemplate.save(team);
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
        return team;
    }

    @Override
    public List<Team> getAll() {
        return hibernateTemplate.loadAll(Team.class);
    }

    @Override
    @Transactional
    public Team getById(Long teamId, Boolean loadPlayersList) {
        Team team = hibernateTemplate.get(Team.class, teamId);
        Hibernate.initialize(team.getPlayersList());
        return team;
    }

    @Override
    public List<Team> getAllTeamsByTeamType(TeamType teamType) {
        Team sampleTeam = new Team();
        sampleTeam.setTeamType(teamType);
        return (List<Team>) this.hibernateTemplate.findByExample(sampleTeam);
    }

    @Override
    public List<Team> getAllByTournament(Tournament tournamentDetails) {
        List<Team> listTeam = new ArrayList<>();
        List<TournamentParticipant> tourPartiList = tourParticipantsDAO.getByTournament(tournamentDetails);
        for(TournamentParticipant tourParticipant: tourPartiList) {
            Team team = this.hibernateTemplate.load(Team.class, tourParticipant.getTeamId());
            listTeam.add(team);
        }
        return listTeam;
    }
}
