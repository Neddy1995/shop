package com.xc.shop.pojo;

import com.xc.shop.bean.Favorite;

import java.math.BigDecimal;

public class FavoritePo extends Favorite {
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
