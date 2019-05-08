package com.xc.shop.dao;

import com.xc.shop.bean.ResultHour;
import com.xc.shop.vo.ResultHourVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResultHourMapper {
    int insert(ResultHour record);

    int insertSelective(ResultHour record);

    // 1 浏览折线图
    List<ResultHour> query1(@Param("type") String type, @Param("time") String time);

    // 2 购买折现图
    List<ResultHour> query2(@Param("type") String type, @Param("time") String time);

    // 3 浏览排行榜
    List<ResultHourVo> query3(@Param("type") String type, @Param("time") String time);

    // 4 购买排行榜
    List<ResultHourVo> query4(@Param("type") String type, @Param("time") String time);
}