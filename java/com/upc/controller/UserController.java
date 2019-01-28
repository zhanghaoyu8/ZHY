package com.upc.controller;

import com.upc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
    //成功 success
    //不存在 notfound
    //密码错误 error
    String res = userService.login(username,password);
    if(res == null){
      res = "404";
    }
    return res;
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  @ResponseBody
  public String register(@RequestParam("username") String username, @RequestParam("password") String password) {
    String res = userService.register(username,password);
    return res;
  }

}
