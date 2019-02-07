package com.xc.shop.dao;

import com.xc.shop.bean.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(String goodId);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(String goodId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}