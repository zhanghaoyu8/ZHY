package com.upc.mapper;

import com.upc.model.CI;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CIMapper {
  int deleteByPrimaryKey(Integer ciid);

  int insert(CI record);

  int insertSelective(CI record);

  CI selectByPrimaryKey(Integer ciid);

  List<CI> selectByCname(@Param("cname") String cname);

  int updateByPrimaryKeySelective(CI record);

  int updateByPrimaryKey(CI record);
}