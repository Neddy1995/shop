package com.xc.shop.dao;

import com.xc.shop.bean.GoodGrandInfo;

public interface GoodGrandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodGrandInfo record);

    int insertSelective(GoodGrandInfo record);

    GoodGrandInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodGrandInfo record);

    int updateByPrimaryKey(GoodGrandInfo record);
}