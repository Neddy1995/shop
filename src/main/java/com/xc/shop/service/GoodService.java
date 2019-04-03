package com.xc.shop.service;

import com.github.pagehelper.PageHelper;
import com.xc.shop.bean.Computer;
import com.xc.shop.bean.GoodBaseInfo;
import com.xc.shop.bean.MobilePhone;
import com.xc.shop.dao.ComputerMapper;
import com.xc.shop.dao.GoodBaseInfoMapper;
import com.xc.shop.dao.GoodBrandInfoMapper;
import com.xc.shop.dao.MobilePhoneMapper;
import com.xc.shop.util.PageBean;
import com.xc.shop.vo.GoodVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GoodService {


    @Autowired
    ComputerMapper computerMapper;

    @Autowired
    GoodBrandInfoMapper goodBrandInfoMapper;

    @Autowired
    GoodBaseInfoMapper goodBaseInfoMapper;

    @Autowired
    MobilePhoneMapper mobilePhoneMapper;

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



    /**
     * 根据商品类型，查询该商品所有的品牌信息，查询结果不对应具体的实体类，所以这里用map
     * @param goodTypeId
     * @return
     */
    public List<Map<String, Object>> selectAllBrandByType(String goodTypeId) {
        return goodBrandInfoMapper.selectAllBrandByType(goodTypeId);
    }


    /**
     * 111 观月PageHelper分页插件，参考：https://www.cnblogs.com/onetwo/p/7371778.html
     * @param goodVo
     * @return
     */
    public PageBean<Map<String, Object>> selectGoodList(GoodVo goodVo) {
        PageHelper.startPage(goodVo.getCurrentPage(), goodVo.getPageSize());
        List<Map<String, Object>> list = goodBaseInfoMapper.selectGoodList(goodVo);        //全部商品

        int countNums = goodBaseInfoMapper.selectGoodListCount(goodVo); //总记录数,再次查询，这个bug不晓得怎么解决，暂时规避这个问题

        PageBean<Map<String, Object>> pageData = new PageBean<>(goodVo.getCurrentPage(), goodVo.getPageSize(), countNums);
        pageData.setItems(list);
        return pageData;
    }

    /**
     * 查询电脑详情
     * @param goodId
     * @return
     */
    public Computer selectComputerGoodDetail(String goodId) {
        return computerMapper.selectComputerGoodDetail(goodId);
    }

    /**
     * 查询手机详情
     * @param goodId
     * @return
     */
    public MobilePhone selectMobilePhoneGoodDetail(String goodId) {
        return mobilePhoneMapper.selectMobilePhoneGoodDetail(goodId);
    }

    /**
     * 查询库存
     * @param goodId
     * @return
     */
    public GoodBaseInfo selectStock(String goodId) {
        return goodBaseInfoMapper.selectStock(goodId);
    }
}













