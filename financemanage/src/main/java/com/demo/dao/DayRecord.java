package com.demo.dao;

import java.util.Date;

public class DayRecord {
    private long id;
    private long userId;
    private String recordDay;
    private String grownAmt;
    private String foodAmt;
    private String houseAmt;
    private String travelAmt;
    private String otherAmt;
    private String month;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getRecordDay() {
        return recordDay;
    }

    public void setRecordDay(String recordDay) {
        this.recordDay = recordDay;
    }

    public String getGrownAmt() {
        return grownAmt;
    }

    public void setGrownAmt(String grownAmt) {
        this.grownAmt = grownAmt;
    }

    public String getFoodAmt() {
        return foodAmt;
    }

    public void setFoodAmt(String foodAmt) {
        this.foodAmt = foodAmt;
    }

    public String getHouseAmt() {
        return houseAmt;
    }

    public void setHouseAmt(String houseAmt) {
        this.houseAmt = houseAmt;
    }

    public String getTravelAmt() {
        return travelAmt;
    }

    public void setTravelAmt(String travelAmt) {
        this.travelAmt = travelAmt;
    }

    public String getOtherAmt() {
        return otherAmt;
    }

    public void setOtherAmt(String otherAmt) {
        this.otherAmt = otherAmt;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
