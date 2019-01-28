package com.upc.service;

import com.upc.mapper.AdminMapper;
import com.upc.model.Admin;
import com.upc.util.HtzxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
  @Autowired
  AdminMapper adminMapper ;
  public boolean validate(String uname,String password){
    int mid = Integer.valueOf(uname);
    String pwd = HtzxUtil.MD5(password);
    Admin admin = adminMapper.selectByPrimaryKey(mid);
    if(admin!=null && pwd.equals(admin.getPassword())){
      return true;
    }
    return false;
  }

}
