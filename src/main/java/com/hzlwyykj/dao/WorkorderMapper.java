package com.hzlwyykj.dao;

import com.hzlwyykj.model.Workorder;

public interface WorkorderMapper {
    int deleteByPrimaryKey(String workorderid);

    int insert(Workorder record);

    int insertSelective(Workorder record);

    Workorder selectByPrimaryKey(String workorderid);

    int updateByPrimaryKeySelective(Workorder record);

    int updateByPrimaryKey(Workorder record);
}