package com.zking.ssm.mapper;

import com.zking.ssm.model.New;

import java.util.List;

public interface NewMapper {
    int deleteByPrimaryKey(Integer newsId);

    int insert(New record);

    int insertSelective(New record);

    New selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(New record);

    int updateByPrimaryKey(New record);

    List<New> queryNewLst();

}