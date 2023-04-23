package com.excel.easy.db.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/***
 *
 */
public class NsjCompanyInfo implements Serializable {
    //编号
    //("编号")
    private String id;
    //单位名称
    //("单位名称")
    private String name;
    //单位类别
    //("单位类别")
    private Integer type;
    //上级单位
    //("上级单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private String parentId;
    //级联路径
    //("级联路径")
    private String treePath;
    //企业负责人
    //("企业负责人")
    private String personIncharge;
    //企业地址
    //("企业地址")
    private String address;
    //企业邮箱
    //("企业邮箱")
    private String email;
    //安全负责人
    //("安全负责人")
    private String personSafety;
    //联系电话
    //("联系电话")
    private String phone;
    //营业执照
    //("营业执照")
    private String licenceFile;
    //资质文件
    //("资质文件")
    private String qualificateFile;
    //公司状态
    //("公司状态")
    private Integer status;
    //审核人
    //("审核人")
    private String auditPerson;

    //审核时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("审核时间")
    private Date auditTime;

    //get set 方法

    public NsjCompanyInfo() {
    }

    public NsjCompanyInfo(String id, String name, String personIncharge, String address, String email, String personSafety, String phone, String licenceFile, String qualificateFile) {
        this.id = id;
        this.name = name;
        this.personIncharge = personIncharge;
        this.address = address;
        this.email = email;
        this.personSafety = personSafety;
        this.phone = phone;
        this.licenceFile = licenceFile;
        this.qualificateFile = qualificateFile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuditPerson() {
        return auditPerson;
    }

    public void setAuditPerson(String auditPerson) {
        this.auditPerson = auditPerson;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentId() {
        return this.parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTreePath() {
        return this.treePath;
    }

    public void setTreePath(String treePath) {
        this.treePath = treePath;
    }

    public String getPersonIncharge() {
        return this.personIncharge;
    }

    public void setPersonIncharge(String personIncharge) {
        this.personIncharge = personIncharge;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonSafety() {
        return this.personSafety;
    }

    public void setPersonSafety(String personSafety) {
        this.personSafety = personSafety;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLicenceFile() {
        return this.licenceFile;
    }

    public void setLicenceFile(String licenceFile) {
        this.licenceFile = licenceFile;
    }

    public String getQualificateFile() {
        return this.qualificateFile;
    }

    public void setQualificateFile(String qualificateFile) {
        this.qualificateFile = qualificateFile;
    }
}
