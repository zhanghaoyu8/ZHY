package com.upc.mapper;

import com.upc.model.Evaluation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EvaluationMapper {
    int deleteByPrimaryKey(Integer evaluationId);

    int insert(Evaluation record);

    int insertSelective(Evaluation record);

    Evaluation selectByPrimaryKey(Integer evaluationId);

    int updateByPrimaryKeySelective(Evaluation record);

    int updateByPrimaryKey(Evaluation record);
}