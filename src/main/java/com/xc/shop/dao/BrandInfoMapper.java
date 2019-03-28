package com.xc.shop.dao;

import com.xc.shop.bean.BrandInfo;

public interface BrandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(BrandInfo record);
}