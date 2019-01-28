package com.upc.controller;

import com.upc.model.Medicine;
import com.upc.service.MedicienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MedicineController {
  @Autowired
  MedicienService medicienService;
  
  @RequestMapping("/addmedicine")
  public String addmedicine() {
    return "addmedicine";
  }

  @RequestMapping(value = "/doaddmedicine",method = {RequestMethod.POST})
  @ResponseBody
  public String doaddmedicine(@RequestBody List<Medicine> medicines) {
    System.out.println(medicines.toString());
    String res = medicienService.addMedicine(medicines);

    return res;
  }


  @RequestMapping("/updatemedicine")
  public String updatemedicine(Model model) {
    return "updatemedicine";
  }

  @RequestMapping("/deletemedicine")
  public String deletemedicine(Model model) {
    return "deletemedicine";
  }

}
