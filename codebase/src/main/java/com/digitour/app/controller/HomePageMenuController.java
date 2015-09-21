package com.digitour.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomePageMenuController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showHomepageMenu() {
        ModelAndView modelAndView = new ModelAndView("homepage");
        modelAndView.addObject("message", "Homepage");
        return modelAndView;
    }
}
