package com.mtkunlun.dubbo.provider.impl;

import java.util.Arrays;
import java.util.List;

import com.mtkunlun.dubbo.api.service.DemoProviderService;


public class DemoProviderImpl implements DemoProviderService{

    public List<String> getMission() {
        return Arrays.asList("test1111","test2222","test3333");
    }
    
}
