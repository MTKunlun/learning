package com.mtkunlun.dubbo.provider.annotation.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;
import com.mtkunlun.dubbo.api.annotation.service.DemoProviderAnnotationService;

@Service(version="1.0",protocol="dubbo")
@Component
public class DemoProviderServiceAnnotationImpl implements DemoProviderAnnotationService {

    public List<String> getMissionAnnotation() {
        return Arrays.asList("anno_test1","anno_test2","anno_test3");
    }

}
