package com.bif.common.model;

import lombok.Data;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 13:19
 * @Version 1.0
 */
@Data
public class ResultBeanGeneric<T> {

    private String code;

    private String msg;

    private T data;


    public ResultBeanGeneric() {
        this.code = Enums.SysCode.SUCCESS.getCode();
        this.msg = Enums.SysCode.SUCCESS.getDesc();
    }

    public ResultBeanGeneric(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBeanGeneric(Enums code, T data, Object[] msgObjs) {
        this.code = code.getCode();
        this.msg = code.getDesc(msgObjs);
        this.data = data;
    }

    public ResultBeanGeneric(Enums enums, T data) {
        this.code = enums.getCode();
        this.msg = enums.getDesc();
        this.data = data;
    }

    public ResultBeanGeneric(Enums enums) {
        this.code = enums.getCode();
        this.msg = enums.getDesc();
    }

    public ResultBeanGeneric(T data) {
        this();
        this.data = data;
    }
}
