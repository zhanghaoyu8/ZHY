package com.upc.controller;

import com.upc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

  @Autowired
  LoginService loginService;
  @RequestMapping("/admin")
  public String adminindex(Model model) {
    return "admin";
  }

  @RequestMapping("/basic")
  public String basic(Model model) {
    return "basic";
  }

  @RequestMapping("/welcome")
  public String welcome(Model model) {
    return "welcome";
  }

  @RequestMapping("/login")
  public String login(Model model) {
    return "login";
  }

  @RequestMapping("/dologin")
  @ResponseBody
  public String dologin(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
    //todo: write some check code here
    if(loginService.validate(username,password)) {
      return "redirect:admin";
    }else {
      return "wrong";
    }
  }
}
