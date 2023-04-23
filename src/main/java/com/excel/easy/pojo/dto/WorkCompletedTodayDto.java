package com.excel.easy.pojo.dto;

public class WorkCompletedTodayDto {//今日工作完成情况
    private String id;//序号
    private String planContent;//计划内容
    private String todayProgress;//今日完成进度
    private String totalProgress;//总完成进度
    private String remark;//备注

    public WorkCompletedTodayDto() {
    }

    public WorkCompletedTodayDto(String id, String planContent, String todayProgress,
                                 String totalProgress, String remark) {
        this.id = id;
        this.planContent = planContent;
        this.todayProgress = todayProgress;
        this.totalProgress = totalProgress;
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent;
    }

    public String getTodayProgress() {
        return todayProgress;
    }

    public void setTodayProgress(String todayProgress) {
        this.todayProgress = todayProgress;
    }

    public String getTotalProgress() {
        return totalProgress;
    }

    public void setTotalProgress(String totalProgress) {
        this.totalProgress = totalProgress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
