package com.digitour.app.controller.homepage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.Tournament;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TournamentManager;

@Controller
public class TournamentController {

    @Autowired
    TournamentManager tourManager;

    @Autowired
    TeamManager teamManager;
    
    @RequestMapping(value="/createnew/tournament", method=RequestMethod.GET)
    public ModelAndView showCreateTournamentForm() {
        ModelAndView modelAndView = new ModelAndView("tournament/createnewtournament");
        return modelAndView;
    }
    
    @RequestMapping(value="/createnew/tournament", method=RequestMethod.POST)
    public ModelAndView handleCreateNewTournament(@RequestParam String tourName, @RequestParam String tourDescription, @RequestParam String tourLocation, 
            @RequestParam String startDate, @RequestParam String endDate, @RequestParam String ageGroup, @RequestParam String prize) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectparticipatingteams");
        modelAndView.addObject("tournamentName", tourName);
        // add tournament details and pass it on to client side for reference
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date tournamentStartDate = null;
        Date tournamentEndDate = null;
        try {
            tournamentStartDate = formatter.parse(startDate);
            tournamentEndDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tournament tournament = new Tournament(tourName, tourDescription, tourLocation, tournamentStartDate, tournamentEndDate, ageGroup, prize);
        tourManager.save(tournament);
        return new ModelAndView("redirect:/selectTournamentParticipant/tournament/"+tournament.getTournamentId());
    }
    
    @RequestMapping(value="/selectTournamentParticipant/tournament/{tournamentId}", method=RequestMethod.GET)
    public ModelAndView handleCreateNewTournament(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectparticipatingteams");
        Tournament tournamentDetails = tourManager.getById(tournamentId);
        modelAndView.addObject("tournamentDetails", tournamentDetails);
        modelAndView.addObject("tournamentName", tournamentDetails.getTournamentName());
        modelAndView.addObject("teamList", teamManager.getAll());
        return modelAndView;
    }

    @RequestMapping(value="/createnew/", method=RequestMethod.POST)
    public ModelAndView handleAddParticipants(@RequestParam String tourName, @RequestParam String tourDescription, @RequestParam String tourLocation, 
            @RequestParam String startDate, @RequestParam String endDate, @RequestParam String ageGroup, @RequestParam String prize) {
        ModelAndView modelAndView = new ModelAndView("tournament/selectparticipatingteams");
        modelAndView.addObject("tournamentName", tourName);
        // add tournament details and pass it on to client side for reference
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date tournamentStartDate = null;
        Date tournamentEndDate = null;
        try {
            tournamentStartDate = formatter.parse(startDate);
            tournamentEndDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Tournament tournament = new Tournament(tourName, tourDescription, tourLocation, tournamentStartDate, tournamentEndDate, ageGroup, prize);
        tourManager.save(tournament);
        return new ModelAndView("redirect:/selectTournamentParticipant/tournament/"+tournament.getTournamentId());
    }
}