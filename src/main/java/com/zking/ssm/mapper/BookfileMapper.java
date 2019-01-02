package com.zking.ssm.mapper;

import com.zking.ssm.model.Bookfile;
import org.springframework.stereotype.Repository;

@Repository
public interface BookfileMapper {

    int insert(Bookfile record);

    Bookfile selectByPrimaryKey(String fileId);
}