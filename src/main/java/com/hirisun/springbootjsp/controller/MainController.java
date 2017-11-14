package com.hirisun.springbootjsp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/")
    public ModelAndView index(){
        LOGGER.debug("This is Index Method!");
        ModelAndView modelAndView =new ModelAndView("index");
        modelAndView.addObject("name","SpringBoot");
        return modelAndView;

    }

    @RequestMapping("/login")
    public String login(){
        LOGGER.debug("This is Login Method!");
        return "login";

    }

}
