package com.upc.controller;

import com.upc.model.OutsideOperation;
import com.upc.service.MedicienService;
import com.upc.service.OutsideOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OutsideOperationController {
  @Autowired
  OutsideOperationService OutsideOperationService;
  
  @RequestMapping("/addoutsideoperation")
  public String addoutsideoperation() {
    return "addoutsideopearation";
  }

  @RequestMapping(value = "/doaddoutsideoperation",method = {RequestMethod.POST})
  @ResponseBody
  public String doaddoutsideoperation(@RequestBody List<OutsideOperation> outsideOperations) {
    System.out.println(outsideOperations.toString());
    String res = OutsideOperationService.addOutsideOperation(outsideOperations);

    return res;
  }


  @RequestMapping("/updateoutsideoperation")
  public String updateoutsideoperation(Model model) {
    return "updateoutsideoperation";
  }

  @RequestMapping("/deleteoutsideoperation")
  public String deleteoperation(Model model) {
    return "deleteoutsideoperation";
  }

}
