package com.demo.dao;

import java.util.Date;

public class UserAssets {
    private long id;
    private long userId;
    private String monthUseAmt;
    private String monthSurplusAmt;
    private String assetsAmt;
    private String securityMonth;
    private String securityAmt;
    private String goalSecurityAmt;
    private String conservativeAmt;
    private String goalConservativeAmt;
    private String investmentAmt;
    private Date createTime;
    private Date updateTime;

    public UserAssets() {
        super();
    }

    public UserAssets(String goalSecurityAmt, String securityAmt, String goalConservativeAmt,  String conservativeAmt, String investmentAmt) {
        this.goalSecurityAmt = goalSecurityAmt;
        this.securityAmt = securityAmt;
        this.goalConservativeAmt = goalConservativeAmt;
        this.conservativeAmt = conservativeAmt;
        this.investmentAmt = investmentAmt;
    }

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

    public String getMonthUseAmt() {
        return monthUseAmt;
    }

    public void setMonthUseAmt(String monthUseAmt) {
        this.monthUseAmt = monthUseAmt;
    }

    public String getMonthSurplusAmt() {
        return monthSurplusAmt;
    }

    public void setMonthSurplusAmt(String monthSurplusAmt) {
        this.monthSurplusAmt = monthSurplusAmt;
    }

    public String getAssetsAmt() {
        return assetsAmt;
    }

    public void setAssetsAmt(String assetsAmt) {
        this.assetsAmt = assetsAmt;
    }

    public String getSecurityMonth() {
        return securityMonth;
    }

    public void setSecurityMonth(String securityMonth) {
        this.securityMonth = securityMonth;
    }

    public String getSecurityAmt() {
        return securityAmt;
    }

    public void setSecurityAmt(String securityAmt) {
        this.securityAmt = securityAmt;
    }

    public String getConservativeAmt() {
        return conservativeAmt;
    }

    public void setConservativeAmt(String conservativeAmt) {
        this.conservativeAmt = conservativeAmt;
    }

    public String getInvestmentAmt() {
        return investmentAmt;
    }

    public void setInvestmentAmt(String investmentAmt) {
        this.investmentAmt = investmentAmt;
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

    public String getGoalSecurityAmt() {
        return goalSecurityAmt;
    }

    public void setGoalSecurityAmt(String goalSecurityAmt) {
        this.goalSecurityAmt = goalSecurityAmt;
    }

    public String getGoalConservativeAmt() {
        return goalConservativeAmt;
    }

    public void setGoalConservativeAmt(String goalConservativeAmt) {
        this.goalConservativeAmt = goalConservativeAmt;
    }
}
