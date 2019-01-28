package com.upc.mapper;

import com.upc.model.Medicine;
import com.upc.model.Msmapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MsmapperMapper {
    int insert(Msmapper record);
    Msmapper selectByPrimaryKey(Integer msmapperId);

    /**
     *
     * @param sname
     * @return 某种病症对应的药品的名字集合
     */
    List<Msmapper> selectBySickName(String sname);
}