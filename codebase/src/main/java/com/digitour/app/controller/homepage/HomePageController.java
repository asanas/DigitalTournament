package com.digitour.app.controller.homepage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.manager.DummyManager;
import com.digitour.app.model.City;
import com.digitour.app.ui.component.menu.Menu;

@Controller
public class HomePageController {

    private static final String MAIN_MENU = "main_menu";

    @Autowired
    private DummyManager dummyManager;
    
    @RequestMapping(value="/home", method=RequestMethod.GET)
    public ModelAndView showHomepage() {
        ModelAndView modelAndView = new ModelAndView("home/homepage");
        List<Menu> homePageMenus = createHomepageMenus();
        modelAndView.addObject("homePageMenus", homePageMenus);
        return modelAndView;
    }

    @RequestMapping(value="/beginQuickMatch", method=RequestMethod.GET)
    public ModelAndView fillDetailsToStratQuickMatch() {
        ModelAndView modelAndView = new ModelAndView("home/quickMatchForm");
        City city = dummyManager.getCityById(1L);
        modelAndView.addObject("city", city);
        return modelAndView;
    }
    
    
    private List<Menu> createHomepageMenus() {
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
    }
}
