package com.xc.shop.dao;

import com.xc.shop.bean.Computer;

import java.util.List;

public interface ComputerMapper {
    int deleteByPrimaryKey(String computerId);

    int insert(Computer record);

    int insertSelective(Computer record);

    Computer selectByPrimaryKey(String computerId);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);

    List<Computer> selectGoodsLikeKeyWord(String keyWord);

    List<Computer> selectGoodsByType(String typeId);
}