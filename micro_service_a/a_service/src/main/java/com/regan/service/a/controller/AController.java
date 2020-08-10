package com.regan.service.a.controller;

import com.regan.service.a.service.AService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController {

    @Autowired
    private AService aService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        return aService.helloA(name);
    }

}
