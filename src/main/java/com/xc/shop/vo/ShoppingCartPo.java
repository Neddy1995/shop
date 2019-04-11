package com.xc.shop.vo;

import com.xc.shop.bean.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartPo extends ShoppingCart {
    private String goodName;
    private BigDecimal price;
    private String type;
    private String goodImg;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String computerName) {
        this.goodName = computerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }
}
