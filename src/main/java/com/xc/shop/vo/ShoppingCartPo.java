package com.xc.shop.vo;

import com.xc.shop.bean.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingCartPo extends ShoppingCart {
    private String computerName;
    private BigDecimal price;

    public String getComputerName() {
        return computerName;
    }

    public void setComputerName(String computerName) {
        this.computerName = computerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
