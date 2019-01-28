package com.upc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {
  @RequestMapping("/test")
  public String testpage(Model model) {
    return "testpage";
  }

  @RequestMapping(value = "/dotest",method = RequestMethod.POST)
  @ResponseBody
  public String dotest(Model model, HttpServletRequest request) {
    System.out.println("enter page");
    String email = request.getParameter("email");
    //需要对提交的项目进行空值判断
    if(email == null || "".equals(email)){
      System.out.println("email is null~!");
    }
    String combmsg = request.getParameter("language");
    String res = "email: "+email+" combvalue: "+combmsg;
    System.out.println(res);
    return res;
  }
  @RequestMapping(value = "/sddata",method = RequestMethod.GET)
  @ResponseBody
  public String sddata(){
    String jsondata = "[\n" +
      "{\"text\":\"Epson WorkForce 845\",\"group\":\"Printer\"},\n" +
      "{\"text\":\"Canon PIXMA MG5320\",\"group\":\"Printer\"},\n" +
      "{\"text\":\"HP Deskjet 1000 Printer\",\"group\":\"Printer\"},\n" +
      "{\"text\":\"Cisco RV110W-A-NA-K9\",\"group\":\"Firewall\"},\n" +
      "{\"text\":\"ZyXEL ZyWALL USG50\",\"group\":\"Firewall\"},\n" +
      "{\"text\":\"NETGEAR FVS318\",\"group\":\"Firewall\"},\n" +
      "{\"text\":\"Logitech Keyboard K120\",\"group\":\"Keyboard\"},\n" +
      "{\"text\":\"Microsoft Natural Ergonomic Keyboard 4000\",\"group\":\"Keyboard\"},\n" +
      "{\"text\":\"Logitech Wireless Touch Keyboard K400\",\"group\":\"Keyboard\"},\n" +
      "{\"text\":\"Logitech Gaming Keyboard G110\",\"group\":\"Keyboard\"},\n" +
      "{\"text\":\"Nikon COOLPIX L26 16.1 MP\",\"group\":\"Camera\"},\n" +
      "{\"text\":\"Canon PowerShot A1300\",\"group\":\"Camera\"},\n" +
      "{\"text\":\"Canon PowerShot A2300\",\"group\":\"Camera\"}\n" +
      "\n" +
      "]";
    return jsondata;
  }
  @RequestMapping(value = "/group",method = RequestMethod.GET)
  public String group(){
    return "group";
  }

}
