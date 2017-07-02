package com.hzlwyykj.dao;

import com.hzlwyykj.model.Workattach;

public interface WorkattachMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Workattach record);

    int insertSelective(Workattach record);

    Workattach selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Workattach record);

    int updateByPrimaryKey(Workattach record);
}