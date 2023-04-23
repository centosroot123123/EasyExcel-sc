package com.excel.easy.util;

import java.util.List;
import java.util.Map;

public class TablePageData<T> {

    private List<T> list;
    private Long total;
    private Map<String, Map<String, String>> dicts;

    public TablePageData() {
    }

    public TablePageData(List<T> list, Long total) {
        this.list = list;
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Map<String, Map<String, String>> getDicts() {
        return dicts;
    }

    public void setDicts(Map<String, Map<String, String>> dicts) {
        this.dicts = dicts;
    }
}
