package com.upc.service;

import com.upc.mapper.IllnessMapper;
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
public class IllnessService {
  private static final Logger logger = LoggerFactory.getLogger(IllnessService.class);
  @Autowired
  IllnessMapper illnessMapper;
  @Autowired
  MsmapperMapper msmapperMapper;
  @Autowired
  SickdetailMapper sickdetailMapper;
  @Autowired
  SickService sickService;
  public String addIllness(List<Illness> illness) {
	    String msg="insert success~!";
	    int suc = 1;
	    for (Illness m : illness) {
	      try{
	        illnessMapper.insert(m);
	      }catch (Exception e){
	        e.getMessage();
	        suc=0;
	      }
	    }
	    if(suc==0){
	      msg="some error happen~!";
	    }
	    return msg;
	  }
}


