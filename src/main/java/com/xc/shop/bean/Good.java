package com.xc.shop.bean;

import java.math.BigDecimal;

public class Good {
    private Integer goodId;//商品id

    private String goodName;//商品名称

    private String goodVersion;//版本

    private String goodColour;//颜色

    private BigDecimal goodPrice;//价格

    private Integer stockNum;//库存数量

    private Integer soldNum;//出售数量

    private Integer detailId;//商品详情表id

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getGoodVersion() {
        return goodVersion;
    }

    public void setGoodVersion(String goodVersion) {
        this.goodVersion = goodVersion == null ? null : goodVersion.trim();
    }

    public String getGoodColour() {
        return goodColour;
    }

    public void setGoodColour(String goodColour) {
        this.goodColour = goodColour == null ? null : goodColour.trim();
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Integer getSoldNum() {
        return soldNum;
    }

    public void setSoldNum(Integer soldNum) {
        this.soldNum = soldNum;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }
}