package com.xc.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 转换时间为时间戳
 */
public class  TimeUtil {

    public  String toString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = format.format(date);
        return dateString;
    }



}
