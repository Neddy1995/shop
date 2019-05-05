package com.xc.shop.bean;

public class Recommend {
    private String goodId;

    private String goodResultId;

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getGoodResultId() {
        return goodResultId;
    }

    public void setGoodResultId(String goodResultId) {
        this.goodResultId = goodResultId == null ? null : goodResultId.trim();
    }
}