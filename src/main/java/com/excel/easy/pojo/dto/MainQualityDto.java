package com.excel.easy.pojo.dto;

public class MainQualityDto {//2. 对主要质量、技术问题的处理措施、处理结果
    private String technicalProblems;//主要质量、技术问题
    private String handlingmMeasures;//处理措施
    private String handlingResult;//处理结果


    public MainQualityDto() {
    }

    public MainQualityDto(String technicalProblems, String handlingmMeasures, String handlingResult) {
        this.technicalProblems = technicalProblems;
        this.handlingmMeasures = handlingmMeasures;
        this.handlingResult = handlingResult;
    }

    public String getTechnicalProblems() {
        return technicalProblems;
    }

    public void setTechnicalProblems(String technicalProblems) {
        this.technicalProblems = technicalProblems;
    }

    public String getHandlingmMeasures() {
        return handlingmMeasures;
    }

    public void setHandlingmMeasures(String handlingmMeasures) {
        this.handlingmMeasures = handlingmMeasures;
    }

    public String getHandlingResult() {
        return handlingResult;
    }

    public void setHandlingResult(String handlingResult) {
        this.handlingResult = handlingResult;
    }
}
