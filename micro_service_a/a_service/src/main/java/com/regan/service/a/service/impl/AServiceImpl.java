package com.regan.service.a.service.impl;

import com.regan.service.a.dao.DataWechatBindMapper;
import com.regan.service.a.service.AService;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AServiceImpl implements AService {

    @Autowired
    private DataWechatBindMapper dataWechatBindMapper;

    @Override
    public String helloA(String name) {
        return "hello "+name;
    }

}
