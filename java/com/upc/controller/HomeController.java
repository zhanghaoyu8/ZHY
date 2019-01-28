package com.upc.controller;


import com.upc.model.*;
import com.upc.service.MedicienService;
import com.upc.service.RecipeService;
import com.upc.service.OutsideOperationService;
import com.upc.util.GsonUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class HomeController {
  private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

  @Autowired
  MedicienService medicienService;
  @Autowired
  RecipeService recipeService;
  @Autowired
  OutsideOperationService outsideOperationService;

  @RequestMapping("/")
  public String index(Model model) {
    return "home";
  }

  /**
   * @param userAnswerSheet
   * @return 某种症状对应的药品
   */
  @RequestMapping(path = {"/msmapper"}, method = {RequestMethod.POST})
  @ResponseBody
  public String queryMedicine(@RequestBody AnswerSheet userAnswerSheet) {
    logger.info("querying drugs...");
    ResultSheet rs = recipeService.getRecipe(userAnswerSheet);
    String res = GsonUtil.toJsonString(rs);
    logger.info("query success!res is:"+res);
    return res;
  }

  /**
   * @param illname
   * @return 症状选择列表
   */
  @RequestMapping(path = {"/symptoms"}, method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public String symptoms(@RequestParam("illname") String illname) {
    logger.info("diagnosing...");
    ViewObject vo = medicienService.getSympotomList(illname);
    String res = GsonUtil.toJsonString((ArrayList<SickDetailItem>) vo.get("symptomsheet"));
    logger.info("diagnos success~!"+res);
    return res;
  }


}