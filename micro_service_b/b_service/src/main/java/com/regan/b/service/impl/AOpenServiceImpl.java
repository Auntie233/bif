package com.regan.b.service.impl;

import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.regan.b.service.AOpenService;
import org.springframework.stereotype.Component;

@Component
public class AOpenServiceImpl implements AOpenService {

    @Override
    public String hello(String name) {
        return "error...";
    }

}
