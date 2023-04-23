package com.excel.easy.pojo.dto;

public class ResultsDto {//对主要安全问题的措施、结果
    private String mainIssues;//主要问题
    private String measures;//措施
    private String result;

    public ResultsDto() {
    }

    public ResultsDto(String mainIssues, String measures, String result) {
        this.mainIssues = mainIssues;
        this.measures = measures;
        this.result = result;
    }

    public String getMainIssues() {
        return mainIssues;
    }

    public void setMainIssues(String mainIssues) {
        this.mainIssues = mainIssues;
    }

    public String getMeasures() {
        return measures;
    }

    public void setMeasures(String measures) {
        this.measures = measures;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
