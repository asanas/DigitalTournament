package com.digitour.app.manager.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitour.app.dao.CityMasterDAO;
import com.digitour.app.dao.PlayerProfileDAO;
import com.digitour.app.dao.TeamDAO;
import com.digitour.app.dao.TournamentDAO;
import com.digitour.app.db.model.City;
import com.digitour.app.db.model.PlayerProfile;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.support.enums.Gender;
import com.digitour.app.db.model.support.enums.MajorSkill;
import com.digitour.app.db.model.support.enums.Role;
import com.digitour.app.db.model.support.enums.TeamType;
import com.digitour.app.manager.DummyManager;
import com.digitour.app.model.example.Category;

@Service
public class DummyManagerImpl implements DummyManager
{

    @Autowired
    CityMasterDAO cityMasterDAO;
    
    @Autowired
    TeamDAO teamMasterDAO;
    
    @Autowired
    PlayerProfileDAO playerProfileMasterDAO;
    
    @Autowired
    TournamentDAO tournamentDAO;
    
    @Override
    public List<City> getAllCities() {
        return cityMasterDAO.getAll();
    }

    @Override
    public City getCityById(Long id) {
        return cityMasterDAO.getById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return cityMasterDAO.getAllCategories();
    }

    @Override
    public void populateTeamData(Integer numberOfTeams, Integer numberOfPlayers) {
        City city = cityMasterDAO.getById(2L);
        for(int i = 1; i<=numberOfTeams;i++) {
            Team dummyTeam = new Team();
            dummyTeam.setName("Dream Test Team"+i);
            dummyTeam.setFounderName("Dream Test Founder");
            dummyTeam.setClubAddressLine1("Dream Test address line - test" + i);
            dummyTeam.setDescription("Dream Test description" + i);
            dummyTeam.setAchievements("Dream Test achievements" + i);
            dummyTeam.setEstablishedIn(new Date());
            dummyTeam.setCity(city);
            dummyTeam.setTeamType(TeamType.CLUB);
            teamMasterDAO.save(dummyTeam);
            
            for(int j =1;j<= numberOfPlayers; j++) {
                PlayerProfile dummyProfile = new PlayerProfile();
                dummyProfile.setFirstName("DFNAME" + j);
                dummyProfile.setLastName("DLNAME" + j);
                dummyProfile.setDateOfBirth(new Date());
                dummyProfile.setAchievements("Dream Test achievements" + j);
                dummyProfile.setCity(city);
                dummyProfile.setContact("DREAM-NUMBER-" + j);
                dummyProfile.setGender(Gender.MALE);
                dummyProfile.setHeight(150);
                dummyProfile.setWeight(60D);
                dummyProfile.setMajorSkill(MajorSkill.DIVE);
                dummyProfile.setRole(Role.ALLROUNDER);
                dummyProfile.setTeam(dummyTeam);
                dummyProfile.setTotalToursParticipated(55);
                playerProfileMasterDAO.save(dummyProfile);
            }
        }
    }

    @Override
    public void startDummyTournament(Tournament tournament) {
        tournamentDAO.save(tournament);
    }

}
