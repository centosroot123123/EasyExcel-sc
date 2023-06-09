package com.excel.easy.pojo.dto;

public class ProjectProgressMilestonesDto {
    private String content;
    private String date;

    public ProjectProgressMilestonesDto() {
    }

    public ProjectProgressMilestonesDto(String content, String date) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
