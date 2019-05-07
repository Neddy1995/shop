package com.xc.shop.vo;

import com.xc.shop.bean.OrderGoods;

import java.util.List;

public class OrderGoodVo extends OrderGoods {
    private List<OrderDetailsPo> list;

    public List<OrderDetailsPo> getList() {
        return list;
    }

    public void setList(List<OrderDetailsPo> list) {
        this.list = list;
    }
}
