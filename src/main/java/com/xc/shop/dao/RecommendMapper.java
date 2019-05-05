package com.xc.shop.dao;

import com.xc.shop.bean.GoodBaseInfo;
import com.xc.shop.bean.Recommend;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecommendMapper {
    int deleteByPrimaryKey(String goodId);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    Recommend selectByPrimaryKey(String goodId);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);

    // 询商品推荐
    List<GoodBaseInfo> selectRecommendList(@Param("goodId") String goodId);
}