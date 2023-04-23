package com.excel.easy.pojo.vo;

public class AutoExportInfoVo {
    private String name;
    private String empty;

    public AutoExportInfoVo(String name,String empty) {
        this.empty = empty;
        this.name = name;
    }

    public String getEmpty() {
        return empty;
    }

    public void setEmpty(String empty) {
        this.empty = empty;
    }

    public AutoExportInfoVo() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
