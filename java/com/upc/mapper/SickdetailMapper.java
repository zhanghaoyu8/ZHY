package com.upc.mapper;

import com.upc.model.Sickdetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SickdetailMapper {
    int deleteByPrimaryKey(Integer sdId);

    int insert(Sickdetail record);

    int insertSelective(Sickdetail record);

    Sickdetail selectByPrimaryKey(Integer sdId);

    /**
     * 根据三个项确定的主键来查找
     * @param iname
     * @param sdname
     * @param sdp
     * @return
     */
    Sickdetail selectByKeyField(@Param("iname") String iname,
                                @Param("sdname") String sdname,
                                @Param("sdp") String sdp);

    List<Sickdetail> selectByIllName(String illname);

    int updateByPrimaryKeySelective(Sickdetail record);

    int updateByPrimaryKey(Sickdetail record);
}