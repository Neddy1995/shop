package com.xc.shop.dao;

import com.xc.shop.bean.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}