package com.xc.shop.dao;

import com.xc.shop.bean.GoodImageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodImageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodImageInfo record);

    int insertSelective(GoodImageInfo record);

    GoodImageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodImageInfo record);

    int updateByPrimaryKey(GoodImageInfo record);

    List<GoodImageInfo> selectImagesByGoodId(@Param("goodId") String goodId);
}