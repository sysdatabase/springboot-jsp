package com.hirisun.springbootjsp.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;


@Controller
public class MainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping({"/","/index"})
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

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam("username")String username,
                          @RequestParam("password")String password,Map<String,String> map){
        LOGGER.debug("This is DoLogin Method!");
        LOGGER.debug("==> username:{}",username);
        LOGGER.debug("==> password:{}",password);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);
        try {
            subject.login(usernamePasswordToken);
        } catch (UnknownAccountException e){
            map.put("message","账号不存在！");
            return "redirect:login";
        } catch (IncorrectCredentialsException e){
            map.put("message","用户名或密码错误！");
            return "redirect:login";
        } catch (Exception e){
            map.put("message","其他错误！");
            return "redirect:login";
        }
        return "redirect:index";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "redirect:logout";
    }

}
