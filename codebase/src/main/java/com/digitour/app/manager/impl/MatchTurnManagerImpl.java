package com.digitour.app.manager.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.MatchTurnDAO;
import com.digitour.app.db.model.MatchTurnDetails;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.db.model.support.enums.TurnStatus;
import com.digitour.app.manager.MatchTurnManager;

@Service
public class MatchTurnManagerImpl implements MatchTurnManager {

    @Autowired
    MatchTurnDAO turnDao;
    
    @Override
    public List<MatchTurnDetails> getTurnsByMatch(TournamentMatchDetails matchDetails) {
        return turnDao.getTurnsByMatch(matchDetails);
    }

    @Override
    public void save(MatchTurnDetails turnDetails) {
        turnDao.save(turnDetails);
    }

    @Override
    public void createMatchTurns(TournamentMatchDetails tournamentMatch) {
        for(long i=1; i<=2;i++) {
            for(long j=1;j<=2;j++) {
                MatchTurnDetails matchTurn = new MatchTurnDetails();
                matchTurn.setTournamentMatchDetails(tournamentMatch);
                matchTurn.setInningNumber(i);
                matchTurn.setTurnNumber(j);
                matchTurn.setStatus(TurnStatus.NOTSTARTED);
                turnDao.save(matchTurn);
            }
        }
    }

    @Override
    public void addInning(TournamentMatchDetails tournamentMatch) {
        for(long i=3; i<=3;i++) {
            for(long j=1;j<=2;j++) {
                MatchTurnDetails matchTurn = new MatchTurnDetails();
                matchTurn.setTournamentMatchDetails(tournamentMatch);
                matchTurn.setInningNumber(i);
                matchTurn.setTurnNumber(j);
                matchTurn.setStatus(TurnStatus.NOTSTARTED);
                turnDao.save(matchTurn);
            }
        }
    }
}
