package com.digitour.app.controller.homepage;

import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.db.model.Team;
import com.digitour.app.db.model.Tournament;
import com.digitour.app.db.model.TournamentMatchDetails;
import com.digitour.app.manager.CityManager;
import com.digitour.app.manager.DummyManager;
import com.digitour.app.manager.PlayerProfileManager;
import com.digitour.app.manager.TeamManager;
import com.digitour.app.manager.TournamentManager;
import com.digitour.app.ui.component.menu.Menu;

@Controller
public class HomePageController {

    private static final Log log = LogFactory.getLog(HomePageController.class);

    
    private static final String MAIN_MENU = "main_menu";

    @Autowired
    DummyManager dummyManager;
    
    @Autowired
    TeamManager teamManager;

    @Autowired
    TournamentManager tournamentManager;
    
    @Autowired
    CityManager cityManager;
    
    @Autowired
    PlayerProfileManager playerProfileManager;

    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView showHomepage() {
        ModelAndView modelAndView = new ModelAndView("home/homepage");
        modelAndView.addObject("homePageMenus", createHomepageMenus());
        return modelAndView;
    }
    
    @RequestMapping(value="/loadTournament/{tournamentId}", method=RequestMethod.GET)
    public ModelAndView showScoresheetHomepage(@PathVariable Long tournamentId) {
        ModelAndView modelAndView = new ModelAndView("home/loadTournament");
        List<Team> teamList = teamManager.getAll();
        modelAndView.addObject("teamList", teamList);
        return modelAndView;
    }

    @RequestMapping(value="/startQuickMatch", method=RequestMethod.POST)
    @ResponseBody
    public String startQuickMatch(@RequestParam Long team1Id, @RequestParam  Long team2Id, @RequestParam Long tossWonBy,
            @RequestParam  String electedTo, @RequestParam Long tournamentId) {
        TournamentMatchDetails tourMatchDetails = tournamentManager.startQuickMatch(team1Id, team2Id, tossWonBy, electedTo, tournamentId);
        return tourMatchDetails.getTournamentMatchId().toString();
    }

    @RequestMapping(value="/beginQuickMatch", method=RequestMethod.GET)
    public ModelAndView fillDetailsToStratQuickMatch() {
        ModelAndView modelAndView = new ModelAndView("home/startquickmatch");
        List<Team> teamList = teamManager.getAll();
        modelAndView.addObject("teamList", teamList);
        modelAndView.addObject("tournamentDetails", new Tournament());
        modelAndView.addObject("tournamentName", "Quick Match");
        return modelAndView;
    }
    
    @RequestMapping(value="/populateTeamData", method=RequestMethod.GET)
    public ModelAndView fillpopulateTeamData(@RequestParam String teamName, @RequestParam Integer numberOfTeams,@RequestParam Integer totalPlayers) {
        ModelAndView modelAndView = new ModelAndView("dummyPage");
        dummyManager.populateTeamData(numberOfTeams, totalPlayers);
        modelAndView.addObject("message", "Team data populated successfully.");
        return modelAndView;
    }
    
    private List<Menu> createHomepageMenus() {
        List<Menu> lstMenu = new ArrayList<Menu>();
        Menu createTour = new Menu();
        createTour.setMenuURL("createnew/tournament");
        createTour.setClassName(MAIN_MENU);
        createTour.setMenuDescription("Create new Tournament");
        createTour.setDisplayText("Create new Tournament");
        
        Menu loadTourMenu = new Menu();
        loadTourMenu.setMenuURL("javascript:void();");
        loadTourMenu.setClassName(MAIN_MENU);
        loadTourMenu.setMenuDescription("Load Tournament");
        loadTourMenu.setDisplayText("Load Tournament");
        loadTourMenu.setJsFunctionCall("showLoadTournamentModal();");

        Menu quickMatchMenu = new Menu();
        quickMatchMenu.setMenuURL("beginQuickMatch");
        quickMatchMenu.setClassName(MAIN_MENU);
        quickMatchMenu.setMenuDescription("Start a quick match");
        quickMatchMenu.setDisplayText("Quick Match");
        
        Menu importExportMenu = new Menu();
        importExportMenu.setMenuURL("import/team");
        importExportMenu.setClassName(MAIN_MENU);
        importExportMenu.setMenuDescription("Import/Export data");
        importExportMenu.setDisplayText("Import/Export");
        
        Menu helpMenu = new Menu();
        helpMenu.setMenuURL("javascript:void();");
        helpMenu.setClassName(MAIN_MENU);
        helpMenu.setMenuDescription("Guidelines");
        helpMenu.setDisplayText("Help!");
        helpMenu.setJsFunctionCall("showAlert('Coming Soon');");
        
        Menu creditsMenu = new Menu();
        creditsMenu.setMenuURL("javascript:void();");
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
    }
    
    
}
