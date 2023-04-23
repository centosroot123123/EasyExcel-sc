package com.excel.easy.util;

import java.util.ArrayList;
import java.util.List;

public class PageUtil<T> {

    private int currentPage;  //当前页

    private int pageSize;   //每页显示的条数

    private int startRow;   //每页开始的条数

    private int totalCount;  //总记录数

    private int totalPage;   //总页数

    private List<T> lists = new ArrayList<T>();  //当前页的数据

    public PageUtil(Integer currentPage, Integer pageSize, Integer totalCount, List<T> auctions) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.lists = auctions;
    }

    public PageUtil() {
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if (currentPage < 1) {
            this.currentPage = 1;
        } else if (currentPage > this.totalPage) {
            this.currentPage = this.totalPage;
        } else {
            this.currentPage = currentPage;
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize <= 0) {
            pageSize = 5;
        }
        this.pageSize = pageSize;
    }

    public int getStartRow() {
        return (this.getCurrentPage() - 1) * this.getPageSize();
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        if (this.getTotalCount() % this.getPageSize() == 0) {
            return this.getTotalCount() / this.getPageSize();
        } else {
            return this.getTotalCount() / this.getPageSize() + 1;
        }
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

}
