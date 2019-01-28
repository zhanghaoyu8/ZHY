package com.upc.service;


import com.upc.mapper.MsmapperMapper;
import com.upc.mapper.OutsideOperationMapper;
import com.upc.mapper.SickdetailMapper;
import com.upc.mapper.SicknessMapper;
import com.upc.model.*;
import com.upc.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SickService {
  private static final Logger logger = LoggerFactory.getLogger(SickService.class);


  @Autowired
  SickdetailMapper sickdetailMapper;
  @Autowired
  SicknessMapper sicknessMapper;
  @Autowired
  MsmapperMapper msmapperMapper;
  @Autowired
  OutsideOperationMapper outsideOperationMapper;
  /**
   * 添加sickdetail
   * @param iname 病名
   * @param sname 病情名
   * @param sp    病情项
   * @param sdindex 病情序号
   * @return 添加结果
   */
  public int addSickDetails(String iname,String sname,String sp,int sdindex,String describe){
    Sickdetail sickdetail = new Sickdetail(iname,sname,sp,sdindex);
    return sickdetailMapper.insert(sickdetail);
  }

  public int addSickness(String sname){
    Sickness sickness = new Sickness();
    sickness.setSickName(sname);
    return sicknessMapper.insert(sickness);
  }

  public int addMsmapper(Sickness sickness, Medicine medicine ,OutsideOperation outsideOperation){

    Msmapper msmapper = new Msmapper();

    msmapper.setMedicineId(medicine.getMedicineId());
    msmapper.setMname(medicine.getMedicineName());
    msmapper.setSicknessId(sickness.getSicknessId());
    msmapper.setSname(sickness.getSickName());

    return msmapperMapper.insert(msmapper);
  }

  public String getsickdetailsJson(String iname ){
    logger.info("进入sd查询病名是:"+iname);
    List<DataGroupItem> dlist = new ArrayList<>();
    List<Sickdetail> sickdetails  = sickdetailMapper.selectByIllName(iname);
    for(Sickdetail sd : sickdetails){
      dlist.add(new DataGroupItem(sd.getSdPerformance(),sd.getSdName()));
    }
    String res = GsonUtil.toJsonString(dlist);
    logger.info("查询结果："+res);
    return res;

  }

}
