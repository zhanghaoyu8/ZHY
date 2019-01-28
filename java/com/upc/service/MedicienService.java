package com.upc.service;

import com.upc.mapper.MedicineMapper;
import com.upc.mapper.SickdetailMapper;
import com.upc.model.Medicine;
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
public class MedicienService {
  @Autowired
  SickdetailMapper sickdetailMapper;
  @Autowired
  MedicineMapper medicineMapper;

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
   * 添加药物
   * @param medicines
   * @return
   */
  public String addMedicine(List<Medicine> medicines) {
    String msg="insert success~!";
    int suc = 1;
    for (Medicine m : medicines) {
      try{
        medicineMapper.insert(m);
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
  public boolean isMedicineExisted(Medicine medicine){
      List<Medicine> medicines = medicineMapper.selectByMname(medicine.getMedicineName());
      if(medicines !=null && medicines.size()!=0){
        return true;
      }
      return false;

  }
  /**
   * 根据json串保存药物数据
   * @param drugsjson
   * @return
   */
  public int addMedicines(String drugsjson) {
    List<Medicine>medicines = GsonUtil.toMedicines(drugsjson);
    int res=0;
    if(medicines!=null && medicines.size()!=0){
      for(Medicine m: medicines){
        //在入库之前先查询药品是否已经存在。如果存在就不插入
        if(isMedicineExisted(m)){
          continue;
        }
        res = medicineMapper.insert(m);
      }
      return res;
    }
    return -1;


  }
}

