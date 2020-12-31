package com.demo.mapper;

import com.demo.dao.DayRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DayRecordMapper {
    int queryCountByCondition(@Param("cm") Map<String, Object> map);
    List<DayRecord> queryByCondition(@Param("cm") Map<String, Object> map);
    void saveDayRecord(DayRecord dayRecord);
    DayRecord queryByDate(DayRecord dayRecord);
    void deleteDayRecord(DayRecord dayRecord);
}
