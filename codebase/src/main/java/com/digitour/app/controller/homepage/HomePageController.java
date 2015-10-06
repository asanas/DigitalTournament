package com.digitour.app.controller.homepage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.dao.TeamDAO;
import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.manager.DummyManager;
import com.digitour.app.manager.TournamentManager;

@Controller
public class HomePageController {

    private static final String MAIN_MENU = "main_menu";

    @Autowired
    private DummyManager dummyManager;
    
    @Autowired
    private TeamDAO teamMasterDAO;

    @Autowired
    TournamentManager tournamentManager;
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView showHomepage() {
        ModelAndView modelAndView = new ModelAndView("home/startquickmatch");
        List<Team> teamList = teamMasterDAO.getAll();
        modelAndView.addObject("teamList", teamList);
        return modelAndView;
    }

    @RequestMapping(value="/startQuickMatch", method=RequestMethod.POST)
    @ResponseBody
    public String startQuickMatch(@RequestParam Long team1Id, @RequestParam  Long team2Id, @RequestParam Long tossWonBy,
            @RequestParam  String electedTo) {
        TournamentMatchDetails tourMatchDetails = tournamentManager.startQuickMatch(team1Id, team2Id, tossWonBy, electedTo);
        return tourMatchDetails.getTournamentMatchId().toString();
    }
    
    @RequestMapping(value="/beginQuickMatch", method=RequestMethod.GET)
    public ModelAndView fillDetailsToStratQuickMatch() {
        ModelAndView modelAndView = new ModelAndView("home/quickmatchform");
//        modelAndView.addObject("categoryList", categoryList);
        return modelAndView;
    }
    
    @RequestMapping(value="/populateTeamData", method=RequestMethod.GET)
    public ModelAndView fillpopulateTeamData(@RequestParam String teamName, @RequestParam Integer numberOfTeams,@RequestParam Integer totalPlayers) {
        ModelAndView modelAndView = new ModelAndView("dummyPage");
        dummyManager.populateTeamData(numberOfTeams, totalPlayers);
        modelAndView.addObject("message", "Team data populated successfully.");
        return modelAndView;
    }
    
    @RequestMapping(value="/loadDemoScoreSheet", method=RequestMethod.GET)
    public ModelAndView showDemoScoreSheet() {
        ModelAndView modelAndView = new ModelAndView("scoresheet/demoscoresheet");
        return modelAndView;
    }
    /*private List<Menu> createHomepageMenus() {
        List<Menu> lstMenu = new ArrayList<Menu>();
        Menu createTour = new Menu();
        createTour.setMenuURL("createNewTournament");
        createTour.setClassName(MAIN_MENU);
        createTour.setMenuDescription("Create new Tournament");
        createTour.setDisplayText("Create new Tournament");
        createTour.setJsFunctionCall("showAlert('Coming Soon');");
        
        Menu loadTourMenu = new Menu();
        loadTourMenu.setMenuURL("loadTournament");
        loadTourMenu.setClassName(MAIN_MENU);
        loadTourMenu.setMenuDescription("Load saved Tournament");
        loadTourMenu.setDisplayText("Load saved Tournament");
        loadTourMenu.setJsFunctionCall("showAlert('Coming Soon');");
        
        Menu quickMatchMenu = new Menu();
        quickMatchMenu.setMenuURL("beginQuickMatch");
        quickMatchMenu.setClassName(MAIN_MENU);
        quickMatchMenu.setMenuDescription("Start a quick match");
        quickMatchMenu.setDisplayText("Quick Match");
        
        Menu importExportMenu = new Menu();
        importExportMenu.setMenuURL("importExport");
        importExportMenu.setClassName(MAIN_MENU);
        importExportMenu.setMenuDescription("Import/Export data");
        importExportMenu.setDisplayText("Import/Export");
        loadTourMenu.setJsFunctionCall("showAlert('Coming Soon');");
        
        Menu helpMenu = new Menu();
        helpMenu.setMenuURL("help");
        helpMenu.setClassName(MAIN_MENU);
        helpMenu.setMenuDescription("Guidelines");
        helpMenu.setDisplayText("Help!");
        helpMenu.setJsFunctionCall("showAlert('Coming Soon');");
        
        Menu creditsMenu = new Menu();
        creditsMenu.setMenuURL("credits");
        creditsMenu.setClassName(MAIN_MENU);
        creditsMenu.setMenuDescription("Credits");
        creditsMenu.setDisplayText("Credits");
        creditsMenu.setJsFunctionCall("showAlert('Coming Soon');");
        
        lstMenu.add(createTour);
        lstMenu.add(loadTourMenu);
        lstMenu.add(quickMatchMenu);
        lstMenu.add(importExportMenu);
        lstMenu.add(helpMenu);
        lstMenu.add(creditsMenu);
        return lstMenu;
    }*/
    
    
}
