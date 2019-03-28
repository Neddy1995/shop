package com.xc.shop.dao;

import com.xc.shop.bean.GoodType;

public interface GoodTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodType record);

    int insertSelective(GoodType record);

    GoodType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodType record);

    int updateByPrimaryKey(GoodType record);
}