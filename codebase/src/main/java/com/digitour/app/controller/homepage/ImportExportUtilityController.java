package com.digitour.app.controller.homepage;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.City;
import com.digitour.app.db.model.Team;
import com.digitour.app.manager.CityManager;
import com.digitour.app.manager.PlayerProfileManager;
import com.digitour.app.manager.impl.TeamManagerImpl;

@Controller
public class ImportExportUtilityController {

    private static final Log log = LogFactory.getLog(ImportExportUtilityController.class);
    
    @Autowired
    CityManager cityManager;
    
    @Autowired
    private TeamManagerImpl teamManager;
    
    @Autowired
    PlayerProfileManager playerProfileManager;
    
    @RequestMapping(value="/import/team", method=RequestMethod.GET)
    public ModelAndView showImportTeamForm() {
        ModelAndView modelAndView = new ModelAndView("importexport/import-team");
        List<City> cityList = cityManager.getAllCities();
        modelAndView.addObject("cityList", cityList);
        return modelAndView;
    }
    
    @RequestMapping(value="/createnew/team", method=RequestMethod.POST)
    @ResponseBody
    public String createNewTeam(@RequestParam String teamName, @RequestParam String founderName, @RequestParam String description,
            @RequestParam String address, @RequestParam String achievements, @RequestParam Long cityId, 
            @RequestParam String establishedIn, @RequestParam MultipartFile playersList) {
        log.debug("Creating a new team.");
        City teamCity = cityManager.getById(cityId);
        Team newTeam = new Team(teamName, founderName, description, address, achievements, teamCity, establishedIn);
        teamManager.save(newTeam);
        playerProfileManager.addPlayersListToTeam(newTeam, playersList);
        return "redirect:/loadTeamDetails/team/"+newTeam.getTeamId();
    }

    
    @RequestMapping(value="/loadTeamDetails/team/{teamId}", method=RequestMethod.GET)
    public ModelAndView loadTeamDetails(@PathVariable Long teamId) {
        ModelAndView modelAndView = new ModelAndView("team/teamdetails");
        log.debug("Creating a new team.");
        Team team = teamManager.getById(teamId);
        modelAndView.addObject("team", team);
        return modelAndView;
    }

}
