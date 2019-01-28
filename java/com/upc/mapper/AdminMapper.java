package com.upc.mapper;

import com.upc.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper

public interface AdminMapper {
  int deleteByPrimaryKey(Integer mid);

  int insert(Admin record);

  int insertSelective(Admin record);

  Admin selectByPrimaryKey(Integer mid);

  int updateByPrimaryKeySelective(Admin record);

  int updateByPrimaryKey(Admin record);
}