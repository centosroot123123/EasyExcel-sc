package com.excel.easy.pojo.dto;


public class KeySecurityMonitoringPointsForTomorrowDto {//明日主要安全监控要点
    private String id;//序号
    private String smp;//安全监控要点
    private String remark;//备注

    public KeySecurityMonitoringPointsForTomorrowDto() {
    }

    public KeySecurityMonitoringPointsForTomorrowDto(String id, String smp, String remark) {
        this.id = id;
        this.smp = smp;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSmp() {
        return smp;
    }

    public void setSmp(String smp) {
        this.smp = smp;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
