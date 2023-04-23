package com.excel.easy.pojo.vo;

public class AutoExport {
    private String id;
    private String name;
    private String company;
    private String phone;
    private String stName;
    private String createUser;
    private String createTime;
    private String content;

    public AutoExport() {
    }

    public AutoExport(String id, String name, String company, String phone, String stName, String createUser, String createTime, String content) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.stName = stName;
        this.createUser = createUser;
        this.createTime = createTime;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStName() {
        return stName;
    }

    public void setStName(String stName) {
        this.stName = stName;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
