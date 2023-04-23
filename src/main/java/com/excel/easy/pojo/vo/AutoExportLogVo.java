package com.excel.easy.pojo.vo;

public class AutoExportLogVo {
    private String name;
    private String company;
    private String logTime;
    private String remark;
    private String isUpdate;

    public AutoExportLogVo() {
    }

    public AutoExportLogVo(String name, String company, String logTime, String remark, String isUpdate) {
        this.name = name;
        this.company = company;
        this.logTime = logTime;
        this.remark = remark;
        this.isUpdate = isUpdate;
    }

    public String getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(String isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLogTime() {
        return logTime;
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
