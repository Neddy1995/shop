package com.xc.shop.vo;

import com.xc.shop.bean.OrderDetails;

public class OrderDetailsPo extends OrderDetails {
    private String goodName;
    private String goodImg;
    private String goodPrice;
    private String goodColor;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    public String getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(String goodPrice) {
        this.goodPrice = goodPrice;
    }

    public String getGoodColor() {
        return goodColor;
    }

    public void setGoodColor(String goodColor) {
        this.goodColor = goodColor;
    }
}
