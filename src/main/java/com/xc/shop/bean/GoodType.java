package com.xc.shop.bean;

public class GoodType {
    private Integer id;

    private String goodTypeId;

    private String goodTypeName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(String goodTypeId) {
        this.goodTypeId = goodTypeId == null ? null : goodTypeId.trim();
    }

    public String getGoodTypeName() {
        return goodTypeName;
    }

    public void setGoodTypeName(String goodTypeName) {
        this.goodTypeName = goodTypeName == null ? null : goodTypeName.trim();
    }
}