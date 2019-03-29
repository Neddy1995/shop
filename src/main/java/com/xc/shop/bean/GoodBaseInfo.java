package com.xc.shop.bean;

public class GoodBaseInfo {
    private Integer id;

    private String goodId;

    private String goodName;

    private String goodTypeId;

    private String brandId;

    private Integer goodPrice;

    private String screenSize;

    private String goodDesc;

    private String sellerId;

    private Integer stock;

    private Integer sold;

    private String upTime;

    private String detailTable;

    private String goodImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
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

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice == null ? null : goodPrice;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize == null ? null : screenSize.trim();
    }

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc == null ? null : goodDesc.trim();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId == null ? null : sellerId.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public String getUpTime() {
        return upTime;
    }

    public void setUpTime(String upTime) {
        this.upTime = upTime == null ? null : upTime.trim();
    }

    public String getDetailTable() {
        return detailTable;
    }

    public void setDetailTable(String detailTable) {
        this.detailTable = detailTable == null ? null : detailTable.trim();
    }

    public String getGoodImg() {
        return goodImg;
    }

    public void setGoodImg(String goodImg) {
        this.goodImg = goodImg == null ? null : goodImg.trim();
    }
}