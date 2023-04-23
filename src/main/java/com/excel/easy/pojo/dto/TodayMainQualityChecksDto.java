package com.excel.easy.pojo.dto;

public class TodayMainQualityChecksDto {//1.今日主要质量检查情况
    private String date;//检查日期
    private String result;//主要质量情况

    public TodayMainQualityChecksDto() {
    }

    public TodayMainQualityChecksDto(String date, String result) {

        this.date = date;
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
