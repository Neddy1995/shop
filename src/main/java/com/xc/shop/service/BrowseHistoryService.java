package com.xc.shop.service;

import com.xc.shop.bean.BrowseHistory;
import com.xc.shop.dao.BrowseHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrowseHistoryService {

    @Autowired
    BrowseHistoryMapper browseHistoryMapper;

    /**
     * 添加历史记录
     * @param record
     */
    public void addData(BrowseHistory record) {
        browseHistoryMapper.addData(record);
    }
}
