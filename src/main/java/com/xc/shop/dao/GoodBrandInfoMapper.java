package com.xc.shop.dao;

import com.xc.shop.bean.GoodBrandInfo;

public interface GoodBrandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodBrandInfo record);

    int insertSelective(GoodBrandInfo record);

    GoodBrandInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodBrandInfo record);

    int updateByPrimaryKey(GoodBrandInfo record);
}