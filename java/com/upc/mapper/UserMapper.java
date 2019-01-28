package com.upc.mapper;

import com.upc.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    User selectByUserName(@Param("uname") String uname);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}