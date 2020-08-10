package com.regan.b.service;

import com.regan.b.service.impl.AOpenServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "A",fallback= AOpenServiceImpl.class)
public interface AOpenService {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable("name") String name);

}
