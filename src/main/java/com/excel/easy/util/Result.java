package com.excel.easy.util;

import java.io.Serializable;

/**
 * 统一返回封装类
 */
public class Result implements Serializable {

    private Integer statusCode;
    private Boolean successful;//请求成功标识
    private Object resultData;//根据接口变化，请求失败时为空
    private String resultHint;//请求提示内容

    public static Result succ(Object data) {
        Result m = new Result();
        m.setStatusCode(200);
        m.setResultData(data);
        m.setResultHint("数据请求成功！");
        m.setSuccessful(true);
        return m;
    }

    public static Result succ(String mess, Object data) {
        Result m = new Result();
        m.setStatusCode(200);
        m.setResultData(data);
        m.setResultHint(mess);
        m.setSuccessful(true);
        return m;
    }


    public static Result fail(String mess) {
        Result m = new Result();
        m.setStatusCode(500);
        m.setResultData(null);
        m.setResultHint(mess);
        m.setSuccessful(false);
        return m;
    }

    public static Result fail(String mess, Object data) {
        Result m = new Result();
        m.setStatusCode(500);
        m.setResultData(data);
        m.setResultHint(mess);
        m.setSuccessful(false);
        return m;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public Result setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }

    public String getResultHint() {
        return resultHint;
    }

    public void setResultHint(String resultHint) {
        this.resultHint = resultHint;
    }
}
