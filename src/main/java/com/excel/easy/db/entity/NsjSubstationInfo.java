package com.excel.easy.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/***
 *
 */
//("场站/项目信息表")
public class NsjSubstationInfo implements Serializable {
    //编号
    //("编号")
    @JsonSerialize(using = ToStringSerializer.class)
    private String id;
    //项目名称
    //("项目名称")
    private String name;
    //项目类别
    //("项目类别")
    private Integer type;
    //上级项目
    //("上级项目")
    @JsonSerialize(using = ToStringSerializer.class)
    private String parentId;
    //级联路径
    //("级联路径")
    private String treePath;
    //主管单位
    //("主管单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private String cmpyOwner;
    //建设单位
    //("建设单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private String cmpyConstruct;
    //监理单位
    //("监理单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private String cmpySupervise;
    //施工单位
    //("施工单位")
    @JsonSerialize(using = ToStringSerializer.class)
    private String cmpyBuild;

    //主管单位
    //("主管单位")
    @TableField(exist = false)
    private String cmpyOwnerName;
    //建设单位
    //("建设单位")
    @TableField(exist = false)
    private String cmpyConstructName;
    //监理单位
    //("监理单位")
    @TableField(exist = false)
    private String cmpySuperviseName;
    //施工单位
    //("施工单位")
    @TableField(exist = false)
    private String cmpyBuildName;
    //项目部
    //("项目部")
    private String department;
    //项目负责人
    //("项目负责人")
    private String personIncharge;
    //项目负责人联系方式
    //("项目负责人联系方式")
    private String personInchargePhone;
    //技术负责人
    //("技术负责人")
    private String personTechnical;
    //技术负责人联系方式
    //("技术负责人联系方式")
    private String personTechnicalPhone;
    //安全负责人
    //("安全负责人")
    private String personSafety;
    //安全负责人联系方式
    //("安全负责人联系方式")
    private String personSafetyPhone;
    //项目部成立文件
    //("项目部成立文件")
    private String departmentFounded;
    //项目经理授权文件
    //("项目经理授权文件")
    private String departmentAuthorize;
    //计划开工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("计划开工时间")
    private Date planStartTime;
    //计划竣工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("计划竣工时间")
    private Date planEndTime;
    //开工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("开工时间")
    private Date startTime;
    //竣工时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    //("竣工时间")
    private Date endTime;
    //当前进度
    //("当前进度")
    @JsonSerialize(using = ToStringSerializer.class)
    private String progress;

    public NsjSubstationInfo(String id, String cmpyBuild, String department, String personIncharge, String personInchargePhone, String personTechnical, String personTechnicalPhone, String personSafety, String personSafetyPhone, String departmentFounded, String departmentAuthorize) {
        this.id = id;
        this.cmpyBuild = cmpyBuild;
        this.department = department;
        this.personIncharge = personIncharge;
        this.personInchargePhone = personInchargePhone;
        this.personTechnical = personTechnical;
        this.personTechnicalPhone = personTechnicalPhone;
        this.personSafety = personSafety;
        this.personSafetyPhone = personSafetyPhone;
        this.departmentFounded = departmentFounded;
        this.departmentAuthorize = departmentAuthorize;
    }

    public NsjSubstationInfo() {
    }

    public String getId() {
        return this.id;
    }

    //get set 方法
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

    public String getCmpyOwner() {
        return this.cmpyOwner;
    }

    public void setCmpyOwner(String cmpyOwner) {
        this.cmpyOwner = cmpyOwner;
    }

    public String getCmpyConstruct() {
        return this.cmpyConstruct;
    }

    public void setCmpyConstruct(String cmpyConstruct) {
        this.cmpyConstruct = cmpyConstruct;
    }

    public String getCmpySupervise() {
        return this.cmpySupervise;
    }

    public void setCmpySupervise(String cmpySupervise) {
        this.cmpySupervise = cmpySupervise;
    }

    public String getCmpyBuild() {
        return this.cmpyBuild;
    }

    public void setCmpyBuild(String cmpyBuild) {
        this.cmpyBuild = cmpyBuild;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPersonIncharge() {
        return this.personIncharge;
    }

    public void setPersonIncharge(String personIncharge) {
        this.personIncharge = personIncharge;
    }

    public String getPersonInchargePhone() {
        return this.personInchargePhone;
    }

    public void setPersonInchargePhone(String personInchargePhone) {
        this.personInchargePhone = personInchargePhone;
    }

    public String getPersonTechnical() {
        return this.personTechnical;
    }

    public void setPersonTechnical(String personTechnical) {
        this.personTechnical = personTechnical;
    }

    public String getPersonTechnicalPhone() {
        return this.personTechnicalPhone;
    }

    public void setPersonTechnicalPhone(String personTechnicalPhone) {
        this.personTechnicalPhone = personTechnicalPhone;
    }

    public String getPersonSafety() {
        return this.personSafety;
    }

    public void setPersonSafety(String personSafety) {
        this.personSafety = personSafety;
    }

    public String getPersonSafetyPhone() {
        return this.personSafetyPhone;
    }

    public void setPersonSafetyPhone(String personSafetyPhone) {
        this.personSafetyPhone = personSafetyPhone;
    }

    public String getDepartmentFounded() {
        return this.departmentFounded;
    }

    public void setDepartmentFounded(String departmentFounded) {
        this.departmentFounded = departmentFounded;
    }

    public String getDepartmentAuthorize() {
        return this.departmentAuthorize;
    }

    public void setDepartmentAuthorize(String departmentAuthorize) {
        this.departmentAuthorize = departmentAuthorize;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPlanStartTime() {
        return this.planStartTime;
    }

    public void setPlanStartTime(Date planStartTime) {
        this.planStartTime = planStartTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPlanEndTime() {
        return this.planEndTime;
    }

    public void setPlanEndTime(Date planEndTime) {
        this.planEndTime = planEndTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProgress() {
        return this.progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getCmpyOwnerName() {
        return cmpyOwnerName;
    }

    public void setCmpyOwnerName(String cmpyOwnerName) {
        this.cmpyOwnerName = cmpyOwnerName;
    }

    public String getCmpyConstructName() {
        return cmpyConstructName;
    }

    public void setCmpyConstructName(String cmpyConstructName) {
        this.cmpyConstructName = cmpyConstructName;
    }

    public String getCmpySuperviseName() {
        return cmpySuperviseName;
    }

    public void setCmpySuperviseName(String cmpySuperviseName) {
        this.cmpySuperviseName = cmpySuperviseName;
    }

    public String getCmpyBuildName() {
        return cmpyBuildName;
    }

    public void setCmpyBuildName(String cmpyBuildName) {
        this.cmpyBuildName = cmpyBuildName;
    }
}
