package com.upc.mapper;
import com.upc.model.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface MedicineMapper {
  int deleteByPrimaryKey(Integer medicineId);

  int insert(Medicine record);

  int insertSelective(Medicine record);

  Medicine selectByPrimaryKey(Integer medicineId);

  List<Medicine> selectByMname(@Param("mname") String mname);

  int updateByPrimaryKeySelective(Medicine record);

  int updateByPrimaryKey(Medicine record);
}