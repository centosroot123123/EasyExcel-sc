package com.excel.easy.pojo.dto;

public class MechanicalConfigurationTodayDto {// 今日机械配置情况
    private String id;//序号
    private String machineName;//机械名称
    private String number;//数量
    private String areasOfUse;//使用部位
    private String remark;//备注

    public MechanicalConfigurationTodayDto() {
    }

    public MechanicalConfigurationTodayDto(String id, String machineName,
                                           String number, String areasOfUse, String remark) {
        this.id = id;
        this.machineName = machineName;
        this.number = number;
        this.areasOfUse = areasOfUse;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAreasOfUse() {
        return areasOfUse;
    }

    public void setAreasOfUse(String areasOfUse) {
        this.areasOfUse = areasOfUse;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
