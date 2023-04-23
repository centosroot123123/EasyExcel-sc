package com.excel.easy.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//(value = "人员信息表")
public class NsjWorkerInfo implements Serializable {
    //("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;
    //("所属项目部编号")
    private String stId;
    //("身份证号")
    private String cardNumber;
    //("年龄:数据库无此字段")
    @TableField(exist = false)
    private Integer age;
    @TableField(exist = false)
    private String pwd;
    //("姓名")
    private String name;
    //性别
    //("性别(1:女，2：男)")
    private Integer gender;
    //联系号码
    //("联系号码")
    private String phone;
    //工种
    //("工种")
    private Integer type;
    //岗位
    //("岗位")
    private Integer position;
    //班组
    //("班组")
    private String team;
    //所属单位
    //("所属单位")
    private String company;
    //培训证书文件
    //("培训证书文件")
    private String certificateFile;
    //照片
    //("照片")
    private String photoFile;
    //人员状态
    //("人员审核状态:0未审核，1已审核")
    private Integer status;
    //审核人
    //("审核人")
    private String auditPerson;
    //审核时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("审核时间")
    private Date auditTime;
    //入场状态
    //("入场状态")
    private Integer enterance;

    private Integer admin;//是否管理人员，1-是，2-否
    private String createUser;

    private String loginName;//登录名

    private Date createTime;

    //培训
    private Integer certificate;
    //岗位附件
    private String positionFile;
    //工种附件
    private String typeFile;

    public String getName() {
        return this.name;
    }

    //get set 方法
    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return this.gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPosition() {
        return this.position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getTeam() {
        return this.team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCertificateFile() {
        return this.certificateFile;
    }

    public void setCertificateFile(String certificateFile) {
        this.certificateFile = certificateFile;
    }

    public String getPhotoFile() {
        return this.photoFile;
    }

    public void setPhotoFile(String photoFile) {
        this.photoFile = photoFile;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditPerson() {
        return this.auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getAuditTime() {
        return this.auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getEnterance() {
        return this.enterance;
    }

    public void setEnterance(Integer enterance) {
        this.enterance = enterance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getCertificate() {
        return certificate;
    }

    public void setCertificate(Integer certificate) {
        this.certificate = certificate;
    }

    public String getPositionFile() {
        return positionFile;
    }

    public void setPositionFile(String positionFile) {
        this.positionFile = positionFile;
    }

    public String getTypeFile() {
        return typeFile;
    }

    public void setTypeFile(String typeFile) {
        this.typeFile = typeFile;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
