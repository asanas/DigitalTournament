package com.digitour.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.digitour.app.ui.component.menu.Menu;

@Controller
@RequestMapping("/home")
public class HomePageMenuController {

    private static final String MAIN_MENU = "main_menu";

	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHomepageMenu() {
        ModelAndView modelAndView = new ModelAndView("homepage");
        List<Menu> homePageMenus = createHomepageMenus(); 
        modelAndView.addObject("homePageMenus", homePageMenus);
        return modelAndView;
    }

    private List<Menu> createHomepageMenus() {
        List<Menu> lstMenu = new ArrayList<Menu>();
        Menu createTour = new Menu();
        createTour.setMenuURL("/createNewTournament");
        createTour.setClassName(MAIN_MENU);
        createTour.setMenuDescription("Create new Tournament");
        createTour.setDisplayText("Create new Tournament");
        
        Menu loadTourMenu = new Menu();
        loadTourMenu.setMenuURL("/loadTournament");
        loadTourMenu.setClassName(MAIN_MENU);
        loadTourMenu.setMenuDescription("Load saved Tournament");
        loadTourMenu.setDisplayText("Load saved Tournament");
        
        Menu quickMatchMenu = new Menu();
        quickMatchMenu.setMenuURL("/quickMatch");
        quickMatchMenu.setClassName(MAIN_MENU);
        quickMatchMenu.setMenuDescription("Start a quick match");
        quickMatchMenu.setDisplayText("Quick Match");
        
        Menu importExportMenu = new Menu();
        importExportMenu.setMenuURL("/importExport");
        importExportMenu.setClassName(MAIN_MENU);
        importExportMenu.setMenuDescription("Import//Export data");
        importExportMenu.setDisplayText("Import//Export");
        
        Menu helpMenu = new Menu();
        helpMenu.setMenuURL("/help");
        helpMenu.setClassName(MAIN_MENU);
        helpMenu.setMenuDescription("Guidelines");
        helpMenu.setDisplayText("Help!");

        Menu creditsMenu = new Menu();
        creditsMenu.setMenuURL("/credits");
        creditsMenu.setClassName(MAIN_MENU);
        creditsMenu.setMenuDescription("Credits");
        creditsMenu.setDisplayText("Credits");

    	return lstMenu;
    }
}
