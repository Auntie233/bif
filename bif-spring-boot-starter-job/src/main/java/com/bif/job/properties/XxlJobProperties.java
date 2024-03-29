package com.bif.job.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "xxl.job", ignoreInvalidFields = true)
public class XxlJobProperties {

    private String adminAddresses;
    private String accessToken;
    private String appName;
    private String address;
    private String ip;
    private int port;
    private String logPath;
    private int logRetentionDays;

}
