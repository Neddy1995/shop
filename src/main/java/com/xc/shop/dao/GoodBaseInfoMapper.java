package com.xc.shop.dao;

import com.xc.shop.bean.GoodBaseInfo;

public interface GoodBaseInfoMapper {
    int insert(GoodBaseInfo record);

    int insertSelective(GoodBaseInfo record);
}