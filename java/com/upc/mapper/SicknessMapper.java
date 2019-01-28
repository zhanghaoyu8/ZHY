package com.upc.mapper;

import com.upc.model.Sickness;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SicknessMapper {
    int deleteByPrimaryKey(Integer sicknessId);

    int insert(Sickness record);

    int insertSelective(Sickness record);

    Sickness selectByPrimaryKey(Integer sicknessId);

    /**
     * 根据病名选择
     * @param sname
     * @return
     */
    Sickness selectBySname(String sname);

    int updateByPrimaryKeySelective(Sickness record);

    int updateByPrimaryKey(Sickness record);
}