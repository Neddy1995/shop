package com.xc.shop.vo;

import com.xc.shop.bean.Favorite;

import java.math.BigDecimal;

public class FavoritePo extends Favorite {
    private String goodName;
    private String goodImg;
    private BigDecimal price;
    private String goodTypeId;
    private String goodId;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(String goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg;
    }

    @Override
    public String getGoodId() {
        return goodId;
    }

    @Override
    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }
}
