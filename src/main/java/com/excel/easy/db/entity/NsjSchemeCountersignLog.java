package com.excel.easy.db.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//
public class NsjSchemeCountersignLog implements Serializable {
    @TableId("id")
    private String id;//
    @TableField("scheme_id")
    private String schemeId;//
    @TableField("signatory")
    private String signatory;//
    @TableField("log_time")
    private Date logTime;//
    @TableField("remark")
    private String remark;//
    @TableField("result")
    private Integer result;//

    public String getId() {
        return this.id;
    }

    //get set 方法
    public void setId(String id) {
        this.id = id;
    }

    public String getSchemeId() {
        return this.schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId;
    }

    public String getSignatory() {
        return this.signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getLogTime() {
        return this.logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }
}
