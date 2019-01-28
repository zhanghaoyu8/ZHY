package com.upc.mapper;

import com.upc.model.OutsideOperation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface OutsideOperationMapper {
  int deleteByPrimaryKey(Integer id);

  int insert(OutsideOperation record);

  int insertSelective(OutsideOperation record);

  OutsideOperation selectByPrimaryKey(Integer id);

  List<OutsideOperation> selectBySname(@Param("sname") String sname);

  int updateByPrimaryKeySelective(OutsideOperation record);

  int updateByPrimaryKey(OutsideOperation record);
}