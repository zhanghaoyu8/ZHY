package com.upc.controller;

import com.upc.model.Illness;
import com.upc.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IllnessController {
  @Autowired
  IllnessService illnessService;
  
  @RequestMapping("/addillness")
  public String addillness() {
    return "addillness";
  }

  @RequestMapping(value = "/doaddillness",method = {RequestMethod.POST})
  @ResponseBody
  public String doaddillness(@RequestBody List<Illness> illnesses) {
    System.out.println(illnesses.toString());
    String res = illnessService.addIllness(illnesses);

    return res;
  }


  @RequestMapping("/updateillness")
  public String updateillness(Model model) {
    return "updateillness";
  }

  @RequestMapping("/deleteillness")
  public String deletemedicine(Model model) {
    return "deleteillness";
  }

}

