package com.hirisun.springbootjsp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
    public ModelAndView index(){
        LOGGER.info("This is Index Method!");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","Springboot");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
