package com.demo.controller;

import com.demo.base.BaseController;
import com.demo.base.PageInfo;
import com.demo.base.ResponseDataMessage;
import com.demo.dao.DayRecord;
import com.demo.service.DayRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DayRecordController  extends BaseController {
    @Autowired
    private DayRecordService dayRecordService;

    @PostMapping(value = "/queryPageInfo")
    public ResponseDataMessage queryPageInfo(@RequestBody Map<String,Object> map) {
        PageInfo<DayRecord> pageInfo = dayRecordService.queryPageInfo(map);
        return this.success(pageInfo);
    }

    @PostMapping(value = "addDayRecord")
    public ResponseDataMessage addDayRecord (@RequestBody DayRecord dayRecord) {
        DayRecord dr = dayRecordService.queryByDate(dayRecord);
        if (dr == null) {
            dayRecordService.saveDayRecord(dayRecord);
            return this.success();
        }
        return this.error("409", "当前日期已有记录，请前往修改或删除！");
    }
    @PostMapping(value = "deleteDayRecord")
    public ResponseDataMessage deleteDayRecord (@RequestBody DayRecord dayRecord) {
        dayRecordService.deleteDayRecord(dayRecord);
        return this.success();
    }
}
