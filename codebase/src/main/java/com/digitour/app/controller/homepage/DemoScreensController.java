package com.digitour.app.controller.homepage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoScreensController {

	@RequestMapping(value="/screens/home", method=RequestMethod.GET)
    public ModelAndView showAllLinks() {
        ModelAndView modelAndView = new ModelAndView("screeens/screensHome");
        List<DemoScreenLink> demoScreenLinks = new ArrayList<>();
        DemoScreenLink linkToScoresheet = new DemoScreenLink("Match Highlights", "/load/demo/scoreSheet", "_blank", true);
        DemoScreenLink linkToScheduledOfPlay = new DemoScreenLink("Scheduled of play", "/load/demo/scheduledPlay", "_blank", true);
        DemoScreenLink linkToTeamStandings = new DemoScreenLink("Team Standings", "/load/demo/scoreSheet", "_blank", false);
        DemoScreenLink linkToMatchResult = new DemoScreenLink("Match Result", "/load/demo/matchResult", "_blank", false);
        demoScreenLinks.add(linkToScoresheet);
        demoScreenLinks.add(linkToScheduledOfPlay);
        demoScreenLinks.add(linkToTeamStandings);
        demoScreenLinks.add(linkToMatchResult);
        return modelAndView;
    }
	
	@RequestMapping(value="/load/demo/scoreSheet", method=RequestMethod.GET)
    public ModelAndView showDemoScoreSheet() {
        ModelAndView modelAndView = new ModelAndView("screens/demoscoresheet");
        modelAndView.addObject("defendingTeamName", "Defending Team Name");
        modelAndView.addObject("chasingTeamName", "Chasing Team Name");
        modelAndView.addObject("defendingTeamScore", 6);
        modelAndView.addObject("chasingTeamScore", 7);
        return modelAndView;
    }
}

class DemoScreenLink {
    String displayText;
    String url;
    String target;
    boolean enabled;
    
    public DemoScreenLink(String displayText, String url, String target, boolean enabled) {
    	this.displayText = displayText;
    	this.url = url;
    	this.target = target;
    	this.enabled = enabled;
	}
	public String getDisplayText() {
		return displayText;
	}
	public String getUrl() {
		return url;
	}
	public String getTarget() {
		return target;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}