package com.xc.shop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ShopApplicationTests {

    @Test
    public void contextLoads() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = format.format(date);

        System.out.printf(dateString);
    }

}

