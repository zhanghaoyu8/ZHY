package com.upc.service;

import com.upc.mapper.MedicineMapper;
import com.upc.mapper.OutsideOperationMapper;
import com.upc.mapper.SickdetailMapper;
import com.upc.model.Medicine;
import com.upc.model.OutsideOperation;
import com.upc.model.SickDetailItem;
import com.upc.model.Sickdetail;
import com.upc.model.ViewObject;
import com.upc.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.View;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class OutsideOperationService {
	@Autowired
	  SickdetailMapper sickdetailMapper;
	  @Autowired
	  OutsideOperationMapper outsideOperationMapper;

  /**
   * @param illname
   * @return
   */
  public ViewObject getSympotomList(String illname) {
    ViewObject vo = new ViewObject();
    vo.set("illname", illname);
    List<Sickdetail> sickdetails = sickdetailMapper.selectByIllName(illname);
    String preKey = null;
    //String tempKey;
    int cid = 0;//当前id
    int preid = 1;//前一个id
    SickDetailItem firstitem = new SickDetailItem();
    List<SickDetailItem> checkboxes = new ArrayList<>();
    for (Sickdetail sd : sickdetails) {

      cid = sd.getSdIndex();
      if (cid == preid) {//同一个病情
        preKey = sd.getSdName();
        firstitem.setSickname(preKey);
        firstitem.getSdPerformance().add(sd.getSdPerformance());
        firstitem.getSdId().add(sd.getSdId());
      } else {
        checkboxes.add(firstitem);
        preid = cid;//更新当前id
        firstitem = null;
        firstitem = new SickDetailItem();
        firstitem.setSickname(preKey);
        firstitem.getSdPerformance().add(sd.getSdPerformance());
        firstitem.getSdId().add(sd.getSdId());
      }
    }
    checkboxes.add(firstitem);//添加最后一个item
    vo.set("symptomsheet", checkboxes);

    return vo;
  }

  /**
   * 添加外治法
   */
  public String addOutsideOperation(List<OutsideOperation> outsideOperation) {
    String msg="insert success~!";
    int suc = 1;
    for (OutsideOperation m : outsideOperation) {
      try{
        outsideOperationMapper.insert(m);
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
  public boolean isOutsideOperationExisted(OutsideOperation outsideOperation){
      List<OutsideOperation> outsideOperations = outsideOperationMapper.selectBySname(outsideOperation.getSicName());
      if(outsideOperations !=null && outsideOperations.size()!=0){
        return true;
      }
      return false;

  }
  /**
   * 根据json串保存数据
   */
  public int addOutsideOperations(String opesjson) {
    List<OutsideOperation>outsideOperation = GsonUtil.toOutsideOperations(opesjson);
    int res=0;
    if(outsideOperation!=null && outsideOperation.size()!=0){
      for(OutsideOperation m: outsideOperation){
        //在入库之前先查询药品是否已经存在。如果存在就不插入
        if(isOutsideOperationExisted(m)){
          continue;
        }
        res = outsideOperationMapper.insert(m);
      }
      return res;
    }
    return -1;


  }
}
