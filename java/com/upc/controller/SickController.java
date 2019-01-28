package com.upc.controller;


import com.upc.model.Category;
import com.upc.model.DataGroupItem;
import com.upc.model.Illness;
import com.upc.model.ReceiveEntity;
import com.upc.service.CIService;
import com.upc.service.MedicienService;
import com.upc.service.RecipeService;
import com.upc.service.OutsideOperationService;
import com.upc.service.SickService;
import com.upc.util.GsonUtil;
import jdk.Exported;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SickController {
  @Autowired
  SickService sickService;
  @Autowired
  CIService ciService;
  @Autowired
  MedicienService medicienService;
  @Autowired
  OutsideOperationService outsideOperationService;
  @Autowired
  RecipeService recipeService;

  @RequestMapping("/addsick")
  public String addsick(Model model) {
    return "addsick";
  }

  @RequestMapping(value = "/adddetails", method = {RequestMethod.POST, RequestMethod.GET})
  public String adddetails(Model model, HttpServletRequest request, HttpSession session) {
    if (request == null) {
      System.out.println("no request~!");
    } else {
      //在adddetails中处理addsick的输入
      String disease = request.getParameter("disease");
      String category = request.getParameter("category");
      //多选
      String snamez[] = request.getParameterValues("multiple");
      //单选
      String singlez[] = request.getParameterValues("single");

      System.out.println("disease: " + disease);
      System.out.println("category: " + category);
      // 保存病名和科室
      Illness ill = new Illness();
      ill.setIllnessName(disease);
      Category category1 = new Category();
      category1.setCname(category);

      ciService.addIllness(ill);
      ciService.addCI(category1, ill);
      List<String> snames = new ArrayList<>();
      List<String> singles = new ArrayList<>();
      if (snamez != null && snamez.length != 0) {

        for (String sname : snamez) {
          //过滤空白的项
          if (isEmptyString(sname)) {
            continue;
          } else {
            snames.add(sname);
          }
        }
      }
      if (singlez != null && singlez.length != 0) {
        for (String sname : singlez) {
          //过滤空白的项
          if (isEmptyString(sname)) {
            continue;
          } else {
            singles.add(sname);
          }
        }
      }

      //保存具体信息进session
      session.setAttribute("disease", disease);
      session.setAttribute("category", category);
      //snams中保存的是多选
      session.setAttribute("snames", snames);
      //singles中保存的是单选
      session.setAttribute("singles", singles);
      //显示之前的输入
      model.addAttribute("disease", disease);
      model.addAttribute("category", category);
      model.addAttribute("snames", snames);
      model.addAttribute("singles",singles);
    }
    return "adddetails";
  }


  @RequestMapping(value = "/addrecipe", method = {RequestMethod.POST, RequestMethod.GET})
  public String addrecipe(Model model, HttpSession session, HttpServletRequest request) {
    //在addrecipe中处理adddetails的输入
    List<String> snames = (List<String>) session.getAttribute("snames");
    List<String> singles = (List<String>) session.getAttribute("singles");
    String iname = (String) session.getAttribute("disease");
    List<DataGroupItem> dlist = new ArrayList<>();
    int si;
    //显示单选的代码
    for (si = 0; si < singles.size(); si++) {
      String sname = singles.get(si);
      
      dlist.add(new DataGroupItem("有", ""+(si+1)+" "+sname));
      dlist.add(new DataGroupItem("无", ""+(si+1)+" "+sname));
      //保存病情选项
      sickService.addSickDetails(iname, sname, "有", si + 1, "1");
      sickService.addSickDetails(iname, sname, "无", si + 1, "1");
    }

    //显示多选的代码
    for (int t = si; t < si+snames.size(); t++) {
      int i=t-si;
      String sname = snames.get(i);
      String[] sdetails = request.getParameterValues("sick" + i);

      for (int j = 0; j < sdetails.length; j++) {
        String sdetail = sdetails[j];
        //忽略空白的输入项
        if (isEmptyString(sdetail)) {
          continue;
        }
        DataGroupItem groupItem = new DataGroupItem(sdetail, ""+(t + 1)+" "+sname);
        dlist.add(groupItem);
        //保存病情选项
        sickService.addSickDetails(iname, sname, sdetail, t + 1, "1");
      }
    }

    String ss = GsonUtil.toJsonString(dlist);
    session.setAttribute("sickdata",ss);


    String title = (String) session.getAttribute("disease");
    model.addAttribute("title",title);
    return"addrecipe";
  }

  /**
   * 保存所有数据
   *
   * @param model
   * @param receiveEntity
   * @return
   */
  @RequestMapping(value = "/saveall", method = RequestMethod.POST)
  @ResponseBody
  public String saveAll(Model model,
                        @RequestBody ReceiveEntity receiveEntity,
                        HttpSession session) {
    String iname = (String) session.getAttribute("disease");//病名

    String drugsJson = receiveEntity.getDrugs();
    String operationsJson = receiveEntity.getOperations();
    String recordJson = receiveEntity.getRecord();
    //添加药物
    medicienService.addMedicines(drugsJson);
    outsideOperationService.addOutsideOperations(operationsJson);
    //填写recipe表 sickness表和msmapper表
    recipeService.addRecipeAndMsmapper(iname, recordJson);

    //清空session中的内容
    session.removeAttribute("disease");
    session.removeAttribute("category");
    session.removeAttribute("snames");
    session.removeAttribute("sickdata");

    return "";
  }


  @RequestMapping(value = "/sickdata", method = {RequestMethod.POST, RequestMethod.GET})
  @ResponseBody
  public String getSickJson(HttpSession session) {
    String ss = (String) session.getAttribute("sickdata");
    return ss;
  }


  @RequestMapping("/updatesick")
  public String updatesick(Model model) {
    return "updatesick";
  }

  @RequestMapping("/deletesick/{sd}")
  public String deletesick(Model model) {
    return "deletesick";
  }

  @RequestMapping("/updaterecipe")
  public String updaterecipe(Model model ,
                             @RequestParam("iname")String iname,
                             HttpSession session) {
    session.setAttribute("disease",iname);//保存到session中
    model.addAttribute("iname",iname);

    return "updaterecipe";
  }
  @RequestMapping("/updatesickdata")
  @ResponseBody
  public String updatesickdata(HttpSession session){
    String iname = (String)session.getAttribute("disease");
    String res = sickService.getsickdetailsJson(iname);
    return res;

  }


  private boolean isEmptyString(String str) {
    if (str == null || "".equals(str.trim())) {
      return true;
    }
    return false;
  }
}
