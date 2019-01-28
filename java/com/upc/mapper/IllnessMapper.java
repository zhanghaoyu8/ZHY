package com.upc.mapper;

import com.upc.model.Illness;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IllnessMapper {
  int deleteByPrimaryKey(Integer illnessId);

  int insert(Illness record);

  int insertSelective(Illness record);

  Illness selectByPrimaryKey(Integer illnessId);

  Illness selectByIname(String iname);

  int updateByPrimaryKeySelective(Illness record);

  int updateByPrimaryKey(Illness record);
}