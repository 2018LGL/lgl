package com.zking.ssm.mapper;

import com.zking.ssm.model.NewCategory;

public interface NewCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NewCategory record);

    int insertSelective(NewCategory record);

    NewCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NewCategory record);

    int updateByPrimaryKey(NewCategory record);
}