package com.bif.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
@Inherited
@Component
public @interface ServiceLog {

    String value();

    boolean isOutter() default false;

}
