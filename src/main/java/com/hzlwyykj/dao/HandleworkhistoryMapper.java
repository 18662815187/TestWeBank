package com.hzlwyykj.dao;

import com.hzlwyykj.model.Handleworkhistory;

public interface HandleworkhistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Handleworkhistory record);

    int insertSelective(Handleworkhistory record);

    Handleworkhistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Handleworkhistory record);

    int updateByPrimaryKey(Handleworkhistory record);
}