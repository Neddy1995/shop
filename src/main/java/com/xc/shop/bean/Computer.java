package com.xc.shop.bean;

import java.math.BigDecimal;

public class Computer {
    private String computerId;

    private String computerName;

    private String computerVersion;

    private String computerColour;

    private BigDecimal price;

    private Integer computerStorkNum;

    private Integer computerSoldNum;

    private String computerImgUrl;

    private String computerCpu;

    private String computerGpu;

    private String computerRom;

    private String computerRam;

    private String computerScreenSize;

    private String computerScreenResolution;

    private Integer computerScreenRefresh;

    private String material;

    private String system;

    private Double weight;

    private String goodId;

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId == null ? null : computerId.trim();
    }

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName == null ? null : computerName.trim();
    }

    public String getComputerVersion() {
        return computerVersion;
    }

    public void setComputerVersion(String computerVersion) {
        this.computerVersion = computerVersion == null ? null : computerVersion.trim();
    }

    public String getComputerColour() {
        return computerColour;
    }

    public void setComputerColour(String computerColour) {
        this.computerColour = computerColour == null ? null : computerColour.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getComputerStorkNum() {
        return computerStorkNum;
    }

    public void setComputerStorkNum(Integer computerStorkNum) {
        this.computerStorkNum = computerStorkNum;
    }

    public Integer getComputerSoldNum() {
        return computerSoldNum;
    }

    public void setComputerSoldNum(Integer computerSoldNum) {
        this.computerSoldNum = computerSoldNum;
    }

    public String getComputerImgUrl() {
        return computerImgUrl;
    }

    public void setComputerImgUrl(String computerImgUrl) {
        this.computerImgUrl = computerImgUrl == null ? null : computerImgUrl.trim();
    }

    public String getComputerCpu() {
        return computerCpu;
    }

    public void setComputerCpu(String computerCpu) {
        this.computerCpu = computerCpu == null ? null : computerCpu.trim();
    }

    public String getComputerGpu() {
        return computerGpu;
    }

    public void setComputerGpu(String computerGpu) {
        this.computerGpu = computerGpu == null ? null : computerGpu.trim();
    }

    public String getComputerRom() {
        return computerRom;
    }

    public void setComputerRom(String computerRom) {
        this.computerRom = computerRom == null ? null : computerRom.trim();
    }

    public String getComputerRam() {
        return computerRam;
    }

    public void setComputerRam(String computerRam) {
        this.computerRam = computerRam == null ? null : computerRam.trim();
    }

    public String getComputerScreenSize() {
        return computerScreenSize;
    }

    public void setComputerScreenSize(String computerScreenSize) {
        this.computerScreenSize = computerScreenSize == null ? null : computerScreenSize.trim();
    }

    public String getComputerScreenResolution() {
        return computerScreenResolution;
    }

    public void setComputerScreenResolution(String computerScreenResolution) {
        this.computerScreenResolution = computerScreenResolution == null ? null : computerScreenResolution.trim();
    }

    public Integer getComputerScreenRefresh() {
        return computerScreenRefresh;
    }

    public void setComputerScreenRefresh(Integer computerScreenRefresh) {
        this.computerScreenRefresh = computerScreenRefresh;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system == null ? null : system.trim();
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId == null ? null : goodId.trim();
    }
}