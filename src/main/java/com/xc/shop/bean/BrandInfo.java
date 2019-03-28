package com.xc.shop.bean;

public class BrandInfo {
    private Integer id;

    private String brandId;

    private String brandName;

    private String brandDes;

    private String img;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId == null ? null : brandId.trim();
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    public String getBrandDes() {
        return brandDes;
    }

    public void setBrandDes(String brandDes) {
        this.brandDes = brandDes == null ? null : brandDes.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}