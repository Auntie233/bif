package com.bif.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 15:02
 * @Version 1.0
 */
@Data
public class ExecuteResult<T> implements Serializable {


    /**
     * @Fields serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Enums rtnEnum;

    private String msg;

    private T data;

    public ExecuteResult() {
        this(Enums.SysCode.SUCCESS);
    }

    public ExecuteResult(Enums rtnEnum) {
        this.setRtnEnum(rtnEnum);
    }

    public ExecuteResult(T data) {
        this();
        this.data = data;
    }

    public ExecuteResult(Enums rtnEnum, T data) {
        this.setRtnEnum(rtnEnum);
        this.data = data;
    }

    public ExecuteResult(Enums rtnEnum, T data, String msg) {
        this.rtnEnum = rtnEnum;
        this.data = data;
        this.msg = msg;
    }

    public ExecuteResult(Enums rtnEnum, T data, Object[] msgObjs) {
        this.rtnEnum = rtnEnum;
        this.data = data;
        this.msg = getMsg(msgObjs);
    }

    public ExecuteResult(Enums rtnEnum, Object[] msgObjs) {
        this.rtnEnum = rtnEnum;
        this.msg = getMsg(msgObjs);
    }

    public String getCode() {
        return rtnEnum.getCode();
    }

    public Enums getRtnEnum() {
        return rtnEnum;
    }

    public void setRtnEnum(Enums rtnEnum) {
        this.rtnEnum = rtnEnum;
        this.msg = rtnEnum.getDesc();
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsg(Object[] msgObjs) {
        if (this.rtnEnum == null || msgObjs == null) {
            return "";
        }
        return this.rtnEnum.getDesc(msgObjs);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ExecuteResult [code=" + rtnEnum.getCode() + ", msg=" + getMsg() + "]";
    }

}
