package com.xc.shop.dao;

import com.xc.shop.bean.GoodBaseInfo;
import com.xc.shop.vo.GoodVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodBaseInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodBaseInfo record);

    int insertSelective(GoodBaseInfo record);

    GoodBaseInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodBaseInfo record);

    int updateByPrimaryKey(GoodBaseInfo record);

    List<Map<String, Object>> selectGoodList(GoodVo goodVo);

    int selectGoodListCount(GoodVo goodVo);

    GoodBaseInfo selectStock(@Param("goodId") String goodId);
}