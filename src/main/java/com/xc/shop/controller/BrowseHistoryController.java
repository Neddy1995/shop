package com.xc.shop.controller;

import com.xc.shop.bean.BrowseHistory;
import com.xc.shop.service.BrowseHistoryService;
import com.xc.shop.util.SessionKeyValue;
import com.xc.shop.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class BrowseHistoryController {

    private static final Logger logger = LoggerFactory.getLogger(BrowseHistoryController.class);

    @Autowired
    BrowseHistoryService browseHistoryService;

    /**
     * 添加历史记录
     * @param session
     * @param goodId
     */
    @GetMapping("/addBrowseHistory.do")
    public void addBrowseHistory(HttpSession session, @RequestParam("goodId") String goodId) {
        BrowseHistory record = new BrowseHistory();

        try {
            String userId = session.getAttribute(SessionKeyValue.USER_ID).toString();
            if(userId.equals("")){
                record.setGoodId(goodId);
                record.setUserId("0");
            }
            else {
                record.setGoodId(goodId);
                record.setUserId(userId);
            }
            TimeUtil timeUtil = new TimeUtil();
            record.setTime(timeUtil.toString(new Date()));
            browseHistoryService.addData(record);

        } catch (Exception e) {
            logger.error("添加历史记录错误" + e);
        }
    }
}














