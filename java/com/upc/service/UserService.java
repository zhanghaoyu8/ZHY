package com.upc.service;

import com.upc.mapper.UserMapper;
import com.upc.model.User;
import com.upc.util.MD5encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  UserMapper userMapper;
  public String login(String username,String password ){
    logger.info("start user login check....");
    String res = null;
    User user = userMapper.selectByUserName(username);
    if(user==null){
      res = "notfound";
    }else if(!user.getPassword().equals(MD5encode.MD5(password))){
      res = "error";
    }else {
      res = "success";
    }
    return res;
  }
  public String register(String usrname,String password){
    logger.info("start user register...");
    String res = null;
    User user = new User();
    user.setUsername(usrname);
    user.setPassword(MD5encode.MD5(password));//密码加密
    User ouser = userMapper.selectByUserName(usrname);
    if(ouser!=null){
      res = "existed";
    }else {
      //保存入库
      userMapper.insertSelective(user);
      res = "success";
    }

    return res;
  }
}
