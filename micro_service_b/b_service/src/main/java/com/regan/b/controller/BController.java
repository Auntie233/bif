package com.regan.b.controller;

import com.regan.b.service.AOpenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

    @Autowired
    private AOpenService aOpenService;

    @Value("${timeout}")
    private Integer timeout;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return aOpenService.hello(name)+"\t"+timeout;
    }

}
