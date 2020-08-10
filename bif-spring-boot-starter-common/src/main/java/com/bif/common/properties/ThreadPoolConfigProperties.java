package com.bif.common.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/3/31 14:07
 * @Version 1.0
 */
@Component
@ConfigurationProperties("spring.thread.pool")
public class ThreadPoolConfigProperties {
    /**
     * 核心线程数（默认线程数）
     */
    private int corePoolSize = 20;
    /**
     * 最大线程数
     */
    private int maxPoolSize = 100;
    /**
     * 允许线程空闲时间（单位：默认为秒）
     */
    private int keepAliveTime = 10;
    /**
     * 缓冲队列大小
     */
    private int queueCapacity = 200;
    /**
     * 线程池名前缀
     */
    private String threadNamePrefix = "Async-Service-";

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public void setCorePoolSize(int corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    public int getMaxPoolSize() {
        return maxPoolSize;
    }

    public void setMaxPoolSize(int maxPoolSize) {
        this.maxPoolSize = maxPoolSize;
    }

    public int getKeepAliveTime() {
        return keepAliveTime;
    }

    public void setKeepAliveTime(int keepAliveTime) {
        this.keepAliveTime = keepAliveTime;
    }

    public int getQueueCapacity() {
        return queueCapacity;
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public String getThreadNamePrefix() {
        return threadNamePrefix;
    }

    public void setThreadNamePrefix(String threadNamePrefix) {
        this.threadNamePrefix = threadNamePrefix;
    }
}
