package com.xc.shop.vo;

import com.xc.shop.bean.OrderGoods;

import java.util.List;

public class OrderGoodVo extends OrderGoods {
    private List<OrderDetailVo> list;

    public List<OrderDetailVo> getList() {
        return list;
    }

    public void setList(List<OrderDetailVo> list) {
        this.list = list;
    }
}
