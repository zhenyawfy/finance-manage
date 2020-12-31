package com.demo.service;

import com.demo.base.PageInfo;
import com.demo.dao.DayRecord;
import com.demo.mapper.DayRecordMapper;
import com.demo.utils.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class DayRecordService {
    @Autowired
    private DayRecordMapper dayRecordMapper;

    public PageInfo<DayRecord> queryPageInfo(Map<String, Object> map) {
        int pageNo = (Integer) map.get("pageNo");
        int pageSize = (Integer) map.get("pageSize");
        int totalNum = dayRecordMapper.queryCountByCondition(map);
        PageInfo<DayRecord> info = new PageInfo<>(pageNo, pageSize);
        map.put("pageIndex", info.getPageIndex());
        map.put("pageIndexEnd", info.getPageIndex() + pageSize);
        List<DayRecord> dayRecords = dayRecordMapper.queryByCondition(map);
        info.setTotalNum(totalNum);
        info.setList(dayRecords);
        return info;
    }

    public void saveDayRecord(DayRecord dayRecord) {
        Date date = new Date();
        dayRecord.setMonth(dayRecord.getRecordDay().substring(0, dayRecord.getRecordDay().length()-2));
        dayRecord.setId(IdUtils.getId());
        dayRecord.setCreateTime(date);
        dayRecord.setUpdateTime(date);
        dayRecordMapper.saveDayRecord(dayRecord);
    }

    public DayRecord queryByDate(DayRecord dayRecord) {
        return dayRecordMapper.queryByDate(dayRecord);
    }

    public void deleteDayRecord(DayRecord dayRecord) {
        dayRecordMapper.deleteDayRecord(dayRecord);
    }
}
