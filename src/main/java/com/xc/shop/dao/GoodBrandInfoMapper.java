package com.xc.shop.dao;

import com.xc.shop.bean.GoodBrandInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodBrandInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodBrandInfo record);

    int insertSelective(GoodBrandInfo record);

    GoodBrandInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodBrandInfo record);

    int updateByPrimaryKey(GoodBrandInfo record);

    List<Map<String, Object>> selectAllBrandByType(@Param("goodTypeId") String goodTypeId);
}