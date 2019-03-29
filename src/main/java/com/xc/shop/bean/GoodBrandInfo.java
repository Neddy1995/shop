package com.xc.shop.bean;

public class GoodBrandInfo {
    private Integer id;

    private String goodTypeId;

    private String brandId;

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

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }
}