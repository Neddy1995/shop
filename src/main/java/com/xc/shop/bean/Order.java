package com.xc.shop.bean;

import java.util.Date;

public class Order {
    private Integer orderId;//订单id

    private Date beginTime;//下单时间

    private Date endTime;//结束时间

    private Integer state;//订单状态（0：失败订单，1：成功完成订单，2：未支付，3：未发货，4：发货中，5：已收货）

    private String userId;//用户id

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}