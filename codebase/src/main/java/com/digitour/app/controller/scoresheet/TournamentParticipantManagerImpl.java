package com.digitour.app.controller.scoresheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.digitour.app.dao.TournamentParticipantDAO;
import com.digitour.app.db.model.TournamentParticipant;
import com.digitour.app.manager.TournamentParticipantManager;

@Repository
public class TournamentParticipantManagerImpl implements TournamentParticipantManager {

    @Autowired
    TournamentParticipantDAO participantDAO;
    @Override
    public TournamentParticipant getById(Long teamParticipant1Id) {
        return participantDAO.getById(teamParticipant1Id);
    }

}
