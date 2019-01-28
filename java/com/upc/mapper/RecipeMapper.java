package com.upc.mapper;

import com.upc.model.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecipeMapper {

    int insert(Recipe record);
    Recipe selectByPrimaryKey(Integer rid);
    List<Recipe> selectByIname(String sname);

}