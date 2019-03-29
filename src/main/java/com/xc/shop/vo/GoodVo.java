package com.xc.shop.vo;

/**
 * 商品的vo
 */
public class GoodVo extends PageVo{

    // 商品名称
    private String goodName;

    // 商品类型id
    private String goodTypeId;

    // 品牌id
    private String brandId;

    // 屏幕大小
    private String screenSize;

    // 价格区间 小
    private Integer minGoodPrice;

    // 价格区间 大
    private Integer maxGoodPrice;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getGoodTypeId() {
        return goodTypeId;
    }

    public void setGoodTypeId(String goodTypeId) {
        this.goodTypeId = goodTypeId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getScreen_size() {
        return screenSize;
    }

    public void setScreen_size(String screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getMinGoodPrice() {
        return minGoodPrice;
    }

    public void setMinGoodPrice(Integer minGoodPrice) {
        this.minGoodPrice = minGoodPrice;
    }

    public Integer getMaxGoodPrice() {
        return maxGoodPrice;
    }

    public void setMaxGoodPrice(Integer maxGoodPrice) {
        this.maxGoodPrice = maxGoodPrice;
    }
}
