package com.xc.shop.controller;

import com.xc.shop.bean.Computer;
import com.xc.shop.service.GoodService;
import com.xc.shop.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private ControllerResult controllerResult;

    /**
     * 根据关键字查询商品信息
     * 商品信息为good的子类computer
     * @param keyWord
     * @return 商品列表
     */
    @PostMapping(value = "/selectByKeyWord.do")
    public ControllerResult selectGoodLikeKeyWord(@RequestParam("keyWord") String keyWord){

        List<Computer> list = goodService.selectGoodsLikeKeyWord(keyWord);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(list);
        return controllerResult;
    }

    /**
     * 根据类型查找商品简要信息
     * 只包含图片，名称，价格
     * @param typeId
     * @return
     */
    @PostMapping(value = "/selectByType.do")
    public ControllerResult selectGoodsByType(@RequestParam("typeId") String typeId){
        List<Computer> list = goodService.selectGoodsByType(typeId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(list);
        return controllerResult;
    }

    /**
     * 根据id查询单个商品
     * @param goodId
     * @return
     */
    @PostMapping(value = "/selectGoodByKey.do")
    public ControllerResult selectGoodByKey(@RequestParam("goodId") String goodId){
        Computer computer = goodService.selectGoodByKey(goodId);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(computer);
        return controllerResult;
    }
}