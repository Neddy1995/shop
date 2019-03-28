package com.xc.shop.dao;

import com.xc.shop.bean.Computer;

import java.util.List;

public interface ComputerMapper {
    int insert(Computer record);

    int insertSelective(Computer record);

    List<Computer> selectGoodsLikeKeyWord(String keyWord);

    List<Computer> selectGoodsByType(String keyWord);

    Computer selectByPrimaryKey(String keyWord);
}