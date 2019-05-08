package com.xc.shop.controller;

import com.xc.shop.bean.ResultHour;
import com.xc.shop.dao.ResultHourMapper;
import com.xc.shop.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnalysisController {

    @Autowired
    ResultHourMapper resultHourMapper;

    /**
     * 查询用户信息
     * @return 用户信息
     */
    @GetMapping(value = "/queryAnalysis.do")
    public ControllerResult userInfo(@RequestParam("type") String type,
                                     @RequestParam("time") String time){
        ControllerResult controllerResult = new ControllerResult();
        Map<String, Object> map = new HashMap<String, Object>();

        List<ResultHour> data1 = resultHourMapper.query1(type, time);
        List<ResultHour> data2 = resultHourMapper.query2(type, time);

        map.put("data1", data1);
        map.put("data2", data2);

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功");
        controllerResult.setData(map);

        return controllerResult;

    }

}