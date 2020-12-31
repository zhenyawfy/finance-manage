package com.demo.base;

import java.util.List;

public class PageInfo<E> {
    private int pageIndex;
    private int pageNo = 1;
    private int pageSize = 10;
    private int totalNum;
    private int toatlPage;
    private List<E> list;

    public PageInfo() {
        super();
    }

    public PageInfo(int pageNo, int pageSize) {
        this.pageIndex = (pageNo - 1) * pageSize;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }


    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.toatlPage = (totalNum + this.pageSize - 1) / this.pageSize;
        this.totalNum = totalNum;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }

    public int getToatlPage() {
        return toatlPage;
    }

    public void setToatlPage(int toatlPage) {
        this.toatlPage = toatlPage;
    }
}
