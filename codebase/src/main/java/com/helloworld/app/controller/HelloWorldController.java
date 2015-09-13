package com.helloworld.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView sayHello() {
		ModelAndView modelAndView = new ModelAndView("helloworld");
		modelAndView.addObject("message", "IT WORKED FINALLY!!! ITS A BEGINING!!!");
		return modelAndView;
	}
}
