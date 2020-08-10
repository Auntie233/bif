package com.bif.common.config;

import com.bif.common.properties.ThreadPoolConfigProperties;
import com.bif.common.util.SpringContextUtil;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description
 * @Author Mr Cui
 * @Date 2020/7/1 16:16
 * @Version 1.0
 */
@EnableAsync
@EnableScheduling
@Configuration
@EnableConfigurationProperties(ThreadPoolConfigProperties.class)
@ConditionalOnProperty(name = "system.env.enabled", havingValue = "true", matchIfMissing = true)
@ComponentScan({"com.bif.common.annotation", "com.bif.common.properties", "com.bif.web.annotation"})
public class AutoConfigurationCore implements SchedulingConfigurer, AsyncConfigurer {


    @Bean
    public SpringContextUtil springContextUtil() {
        return new SpringContextUtil();
    }

    /**
     * 定时任务使用的线程池
     *
     * @return
     */
    @Bean(destroyMethod = "shutdown", name = "taskScheduler")
    public ThreadPoolTaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(10);
        scheduler.setThreadNamePrefix("task-");
        scheduler.setAwaitTerminationSeconds(600);
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.initialize();
        return scheduler;
    }


    @Bean(name = "asyncExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolConfigProperties threadPoolConfigProperties =
                (ThreadPoolConfigProperties) SpringContextUtil.getBean("threadPoolConfigProperties");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(threadPoolConfigProperties.getCorePoolSize());
        executor.setMaxPoolSize(threadPoolConfigProperties.getMaxPoolSize());
        executor.setQueueCapacity(threadPoolConfigProperties.getQueueCapacity());
        executor.setKeepAliveSeconds(threadPoolConfigProperties.getKeepAliveTime());
        executor.setThreadNamePrefix(threadPoolConfigProperties.getThreadNamePrefix());
        // 线程池对拒绝任务的处理策略
        // CallerRunsPolicy：由调用线程（提交任务的线程）处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 初始化
        executor.initialize();
        return executor;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        ThreadPoolTaskScheduler taskScheduler = taskScheduler();
        scheduledTaskRegistrar.setTaskScheduler(taskScheduler);
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (throwable, method, objects) -> {
//            loger.error("异步任务执行出现异常, message {}, emthod {}, params {}", throwable, method, objects);
        };
    }
}
