package com.upc.service;

import com.upc.mapper.MedicineMapper;
import com.upc.mapper.OutsideOperationMapper;
import com.upc.mapper.MsmapperMapper;
import com.upc.mapper.RecipeMapper;
import com.upc.mapper.SickdetailMapper;
import com.upc.model.*;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.upc.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {
  private static final Logger logger = LoggerFactory.getLogger(RecipeService.class);
  @Autowired
  RecipeMapper recipeMapper;
  @Autowired
  MsmapperMapper msmapperMapper;
  @Autowired
  MedicineMapper medicineMapper;
  @Autowired
  SickdetailMapper sickdetailMapper;
  @Autowired
  SickService sickService;
  @Autowired
  OutsideOperationMapper outsideOperationMapper;
  private Set<Integer> getSympons(Recipe recipe) {
    Set<Integer> recipeSympoms = new TreeSet<>();
    String[] osy = recipe.getSymptom().split(" ");
    for (String os : osy) {
      recipeSympoms.add(Integer.valueOf(os));
    }
    return recipeSympoms;
  }
  private int getIntersection(Set<Integer> rs, Set<Integer> us) {
    int m = 0;
    for (Integer i : us) {
      if (rs.contains(i)) {
        m++;
      }
    }
    return m;
  }

  public ResultSheet getRecipe(AnswerSheet userAnswerSheet) {
    String iname = userAnswerSheet.getIllname();
    Set<Integer> us = userAnswerSheet.getUs();
    logger.info(userAnswerSheet.toString());
    return checkRecipes(iname, us);
  }
  public ResultSheet checkRecipes(String iname, Set<Integer> userSympoms) {
    double union = 0;
    double max_matched_degree = 0;
    List<Recipe> recipes = recipeMapper.selectByIname(iname);
    String sickname = null;
    double divisor = 0;
    double sumSize = 0;
    for (Recipe recipe : recipes)
    {
      Set<Integer> recipeSympoms = getSympons(recipe);
      sumSize += recipeSympoms.size();
    }
    divisor = userSympoms.size()/(sumSize/recipes.size());//根据每个集合的大小和问卷集合的关系生成除数
    for (Recipe recipe : recipes) {
      //获取数据库中的集合
      Set<Integer> recipeSympoms = getSympons(recipe);
      //用户集合和数据库中的集合进行求交，返回交集个数
      int match = getIntersection(recipeSympoms, userSympoms);
      //如果交集满足条件
      if (match >= recipe.getMatchs()) {
        //求并集
        union = recipeSympoms.size() + userSympoms.size()/divisor - match;
        //logger.info(recipe.getSname()+"—匹配度"+match+"/"+union+"="+(double)match/(double)union);
        //求最大的匹配度
        if(max_matched_degree<=((double)match/(double)union)){
          max_matched_degree = (double)match/(double)union;
          sickname = recipe.getSname();

        }
      }
    }
    if (sickname == null) {
      //遍历了之后没有得到结果，则返回第一个诊断结果
      logger.info("++++");
      try {
        sickname = recipes.get(0).getSname();
      }
      catch (Exception e) {
        logger.info(e.getMessage());
      }
    }
    else{
      logger.info("匹配成功！诊断的病症是: " + sickname);

    }
    ResultSheet rs = new ResultSheet();
    rs.setSickname(sickname);
    rs.setMedicines(getMedicines(sickname));
    rs.setOutsideOperations(getOutsideOperations(sickname));
    //logger.info("!!!!!!!!!!!!!!!!!");
    return rs;
  }
  /**
   * @param sickname 症状名
   */
  public List<Medicine> getMedicines(String sickname) {
    List<Medicine> medicines = new ArrayList<>();
    List<Msmapper> msmappers = msmapperMapper.selectBySickName(sickname);
    for (Msmapper ms : msmappers) {
      //根据id获取药物
      medicines.add(medicineMapper.selectByPrimaryKey(ms.getMedicineId()));
    }
    return medicines;
  }
  /**
   * 添加诊断关系
   *
   * @return
   */
  public List<OutsideOperation> getOutsideOperations(String sickname) {
	  List<OutsideOperation> outsideOperations = new ArrayList<>();
	  //List<Msmapper> msmappers = msmapperMapper.selectBySickName(sickname);

      outsideOperations = outsideOperationMapper.selectBySname(sickname);

	    return outsideOperations;
	  }
  public int addRecipe(String iname,String sname,String syptoms,int match){
    Recipe recipe = new Recipe();
    recipe.setIname(iname);
    recipe.setMatchs(match);
    recipe.setSname(sname);
    recipe.setSymptom(syptoms);
    return recipeMapper.insert(recipe);
  }
  public String getSympons(String iname,List<String>syps){
    StringBuffer symptonms = new StringBuffer();
    //sdname:sdper 的形式

    for(String sy:syps){
      String []rs = sy.split(":");
//      List<Sickdetail> sickdetails = sickdetailMapper.selectByKeyField(iname,rs[0],rs[1]);
//      if(sickdetails.size()==0){
//        logger.info("sickdetalis not found");
//      }
      //此处可能产生异常,在前两步重复录入数据时发生
      Sickdetail sickdetail = sickdetailMapper.selectByKeyField(iname,rs[0],rs[1]);
      int sdid = sickdetail.getSdId();//获取到id
      symptonms.append(sdid+" ");
    }
    return symptonms.toString().trim();//把最后多余的空格去掉

  }

  public void addRecipeAndMsmapper(String iname,String recordjson){
    logger.info("start add recipe and msmapper");

    List<Record> records = GsonUtil.toRecordList(recordjson);
    //add recipe
    for(Record record:records){//一条record对应一个recipe
      String symptonms = getSympons(iname,record.getSymptoms());
      String sname = record.getSname();
      Recipe recipe = new Recipe();
      recipe.setIname(iname);
      recipe.setSymptom(symptonms);
      recipe.setMatchs(Integer.valueOf(record.getMatch()));
      recipe.setSname(sname);

      recipeMapper.insert(recipe);
      //add sickness
      sickService.addSickness(sname);
      //add msmapper
      List<String> drugs = record.getDrugs();
      for(String drug:drugs){
        Msmapper ms = new Msmapper();
        ms.setSname(sname);
        ms.setMname(drug);//设置药名
        msmapperMapper.insert(ms);
      }
      List<String> operations = record.getOperations();
      for(String m:operations)
      {
    	  OutsideOperation oo = new OutsideOperation();
    	  oo.setSicName(sname);
    	  outsideOperationMapper.insert(oo);
      }
    } 

  }

}

