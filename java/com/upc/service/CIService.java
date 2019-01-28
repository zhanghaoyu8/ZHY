package com.upc.service;

import com.upc.mapper.CIMapper;
import com.upc.mapper.CategoryMapper;
import com.upc.mapper.IllnessMapper;
import com.upc.model.CI;
import com.upc.model.Category;
import com.upc.model.Illness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 处理有关illness和category的业务
 */

@Service
public class CIService {
  @Autowired
  IllnessMapper illnessMapper;
  @Autowired
  CategoryMapper categoryMapper;
  @Autowired
  CIMapper ciMapper ;

  /**
   * 添加病症
   * @param ill
   * @return
   */
  public int addIllness(Illness ill){
    return illnessMapper.insert(ill);
  }

  /**
   * 添加科室
   * @param category
   * @return
   */
  public int addCategory(Category category){
    return categoryMapper.insert(category);
  }

  /**
   * 添加病情-科室关系
   * @param category
   * @param ill
   * @return
   */
  public int addCI(Category category,Illness ill){
    CI ci = new CI();
    ci.setCname(category.getCname());
    ci.setIname(ill.getIllnessName());
    return ciMapper.insert(ci);
  }
}
