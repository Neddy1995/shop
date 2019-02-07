package com.xc.shop.controller;

import com.xc.shop.bean.Computer;
import com.xc.shop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    private GoodService goodService;

    /**
     * 根据关键字查询商品信息
     * 商品信息为good的子类computer
     * @param keyWord
     * @return 商品列表
     */
    @RequestMapping("/selectByKeyWord")
    public List<Computer> selectGoodLikeKeyWord(String keyWord){
        List<Computer> list = goodService.selectGoodsLikeKeyWord(keyWord);
        return list;
    }

    /**
     * 根据类型查找商品简要信息
     * 只包含图片，名称，价格
     * @param typeId
     * @return
     */
    @RequestMapping("/selectByType")
    public List<Computer> selectGoodsByType(String typeId){
        List<Computer> list = goodService.selectGoodsByType(typeId);
        return list;
    }
}