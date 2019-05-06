package com.xc.shop.vo;

import com.xc.shop.bean.OrderDetails;

import java.util.List;

public class OrderDetailVo extends OrderDetails {
    private List<String> list;

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
