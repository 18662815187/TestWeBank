package com.hzlwyykj.dao;

import com.hzlwyykj.model.Data;

public interface DataMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}