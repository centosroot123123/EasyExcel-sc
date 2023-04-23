package com.excel.easy.pojo.dto;

public class MonitoringPointsDto {//3. 明日主要质量监控要点
    private String id;//序号
    private String qualityControlPoints;//质量监控要点
    private String remark;//备注

    public MonitoringPointsDto() {
    }

    public MonitoringPointsDto(String id, String qualityControlPoints, String remark) {
        this.id = id;
        this.qualityControlPoints = qualityControlPoints;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQualityControlPoints() {
        return qualityControlPoints;
    }

    public void setQualityControlPoints(String qualityControlPoints) {
        this.qualityControlPoints = qualityControlPoints;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
