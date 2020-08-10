package com.bif.common.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 13:18
 * @Version 1.0
 */
@Data
public class PageReq {

    @NotNull(message = "页码不能为空")
    private Integer page;

    @NotNull(message = "单页显示数量不能为空")
    private Integer limit;

}
