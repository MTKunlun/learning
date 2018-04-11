package com.mtkunlun.dubbo.provider.annotation.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.mtkunlun.dubbo.api.annotation.service.DemoProviderAnnotationService;

@Service(version = "2.0")
@Component
public class DemoProviderServiceAnnotationImpl implements DemoProviderAnnotationService {

    public List<String> getMissionAnnotation() {
        return Arrays.asList("anno_test1111","anno_test2222","anno_test3333");
    }

}
