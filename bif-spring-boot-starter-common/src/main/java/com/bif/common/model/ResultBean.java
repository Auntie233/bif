package com.bif.common.model;

import lombok.Data;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 13:19
 * @Version 1.0
 */
@Data
public class ResultBean {

    private String code;

    private String msg;

    private Object data;


    public ResultBean() {
        this.code = Enums.SysCode.SUCCESS.getCode();
        this.msg = Enums.SysCode.SUCCESS.getDesc();
    }

    public ResultBean(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(Enums code, Object data, Object[] msgObjs) {
        this.code = code.getCode();
        this.msg = code.getDesc(msgObjs);
        this.data = data;
    }

    public ResultBean(Enums enums, Object data) {
        this.code = enums.getCode();
        this.msg = enums.getDesc();
        this.data = data;
    }

    public ResultBean(Enums enums) {
        this.code = enums.getCode();
        this.msg = enums.getDesc();
    }

    public ResultBean(Object data) {
        this();
        this.data = data;
    }

}
