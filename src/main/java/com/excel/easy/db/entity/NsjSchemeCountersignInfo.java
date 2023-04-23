package com.excel.easy.db.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//
public class NsjSchemeCountersignInfo implements Serializable {
    @TableId("id")
    private String id;//
    @TableField("scheme_id")
    private String schemeId;//
    @TableField("signatory")
    private String signatory;//
    @TableField(value = "result", updateStrategy = FieldStrategy.IGNORED)
    private Integer result;//
    @TableField("update_time")
    private Date updateTime;//
    @TableField(value = "remark", updateStrategy = FieldStrategy.IGNORED)
    private String remark;//

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

    public Integer getResult() {
        return this.result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
