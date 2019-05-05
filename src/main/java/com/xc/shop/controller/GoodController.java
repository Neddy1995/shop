package com.xc.shop.controller;

import com.xc.shop.bean.*;
import com.xc.shop.dao.GoodImageInfoMapper;
import com.xc.shop.service.GoodService;
import com.xc.shop.util.ControllerResult;
import com.xc.shop.util.PageBean;
import com.xc.shop.vo.GoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private GoodImageInfoMapper goodImageInfoMapper;

    /**
     * 根据关键字查询商品信息
     * 商品信息为good的子类computer
     * @param keyWord
     * @return 商品列表
     */
    @PostMapping(value = "/selectByKeyWord.do")
    public ControllerResult selectGoodLikeKeyWord(@RequestParam("keyWord") String keyWord){

        List<Computer> list = goodService.selectGoodsLikeKeyWord(keyWord);
        ControllerResult controllerResult = new ControllerResult();
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
        ControllerResult controllerResult = new ControllerResult();
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
        ControllerResult controllerResult = new ControllerResult();
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功！");
        controllerResult.setData(computer);
        return controllerResult;
    }


    /** 111
     * 根据商品类型，查询该商品所有的品牌信息，查询结果不对应具体的实体类，所以这里用map
     * @param goodTypeId
     * @return
     */
    @GetMapping(value = "/selectAllBrandByType.do")
    public ControllerResult selectAllBrandByType(@RequestParam("goodTypeId") String goodTypeId) {

        ControllerResult result = new ControllerResult();
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        try {
            list = goodService.selectAllBrandByType(goodTypeId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(list);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 111  商品列表接口
     * @param goodVo
     * @return
     */
    @GetMapping(value = "/selectGoodList.do")
    public ControllerResult selectGoodList(GoodVo goodVo) {

        ControllerResult result = new ControllerResult();
        PageBean<Map<String, Object>> list = new PageBean<Map<String, Object>>();

        try {
            list = goodService.selectGoodList(goodVo);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(list);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 111 查询电脑详情
     * @param goodId
     * @return
     */
    @GetMapping(value = "/selectComputerGoodDetail.do")
    public ControllerResult selectComputerGoodDetail(@RequestParam("goodId") String goodId) {

        ControllerResult result = new ControllerResult();

        try {
            Computer computer = goodService.selectComputerGoodDetail(goodId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(computer);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 111 查询手机详情
     * @param goodId
     * @return
     */
    @GetMapping(value = "/selectMobilePhoneGoodDetail.do")
    public ControllerResult selectMobilePhoneGoodDetail(@RequestParam("goodId") String goodId) {

        ControllerResult result = new ControllerResult();

        MobilePhone mobilePhone;

        try {
            mobilePhone = goodService.selectMobilePhoneGoodDetail(goodId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(mobilePhone);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 111 查询库存
     * @param goodId
     * @return
     */
    @GetMapping(value = "/selectStock.do")
    public ControllerResult selectStock(@RequestParam("goodId") String goodId) {

        ControllerResult result = new ControllerResult();
        GoodBaseInfo goodBaseInfo;

        try {
            goodBaseInfo = goodService.selectStock(goodId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(goodBaseInfo);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 111 查询图片集合
     * @param goodId
     * @return
     */
    @GetMapping(value = "/selectImagesByGoodId.do")
    public ControllerResult selectImagesByGoodId(@RequestParam("goodId") String goodId) {
        ControllerResult result = new ControllerResult();

        List<GoodImageInfo> resultList = new ArrayList<GoodImageInfo>();

        try {

            resultList = goodImageInfoMapper.selectImagesByGoodId(goodId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(resultList);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询商品推荐
     * @param goodId
     * @return
     */
    @GetMapping(value = "/selectRecommendList.do")
    public ControllerResult selectRecommendList(@RequestParam("goodId") String goodId) {
        ControllerResult result = new ControllerResult();

        List<GoodBaseInfo> resultList = new ArrayList<GoodBaseInfo>();

        try {

            resultList = goodService.selectRecommendList(goodId);

            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询成功！");
            result.setData(resultList);
        } catch (Exception e) {
            result.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            result.setMessage("查询报错：" + e);
            e.printStackTrace();
        }
        return result;
    }


}




















