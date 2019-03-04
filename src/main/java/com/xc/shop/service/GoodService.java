package com.xc.shop.service;

import com.xc.shop.bean.Computer;
import com.xc.shop.dao.ComputerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {


    @Autowired
    ComputerMapper computerMapper;

    /**
     * 根据关键字查询商品信息
     * 查询的是good子类computer类
     * @param keyWord
     * @return
     */
    public List<Computer> selectGoodsLikeKeyWord(String keyWord){
        List<Computer> list = computerMapper.selectGoodsLikeKeyWord(keyWord);
        return list;
    }

    /**
     * 根据类型查找商品简要信息
     * @param typeId
     * @return 商品简要信息
     */
    public List<Computer> selectGoodsByType(String typeId){
        List<Computer> list = computerMapper.selectGoodsByType(typeId);
        return list;
    }


    /**
     * 根据id查询单个详细商品
     * 需要修改：判断id的类型判断是手机还是电脑
     * @param goodId
     * @return
     */
    public Computer selectGoodByKey(String goodId) {
        Computer computer = computerMapper.selectByPrimaryKey(goodId);
        return computer;
    }
}
