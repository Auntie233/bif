package com.bif.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/27 13:11
 * @Version 1.0
 */
@Data
public class BaseModel implements Serializable {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date recordTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

//    private String host = PropertiesUtils.getProperty("file.download.host");

}
