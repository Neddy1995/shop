package com.xc.shop.dao;

import com.xc.shop.bean.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer goodId);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer goodId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}