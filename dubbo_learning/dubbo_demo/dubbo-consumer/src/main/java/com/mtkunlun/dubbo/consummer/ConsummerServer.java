package com.mtkunlun.dubbo.consummer;

import java.io.IOException;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mtkunlun.dubbo.api.annotation.service.DemoProviderAnnotationService;
import com.mtkunlun.dubbo.api.service.DemoProviderService;

/**
 * 
 * @Description： 功能描述
 * @author MTKunlun on [2018年4月11日下午8:14:07]
 * @Modified By： [修改人] on [修改日期] for [修改说明]
 *
 */
public class ConsummerServer {
    
    //读取配置文件
    public static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-consummer.xml");
    
    public static void main(String[] args) throws IOException, InterruptedException {

        context.start();
        
        boolean flag = true;
        int freq = 0;
        long sum_time = 0;
        long first_ini_time = 0;
        
        //测试101次，第一次时间不算入总时间中，因为第一次会将获取到的地址列表缓存在本地中，因此所需时间较长。
        while(flag && freq <= 100) {
            try {
                long startTime = System.currentTimeMillis();
                
                getMission("demoService");
                getAnnotationMission("demoAnnotationService");
                
                getMission("demoService1");
                getAnnotationMission("demoAnnotationService1");
                
                long endTime = System.currentTimeMillis();
                
                freq++;
                
                if(freq != 1) {
                    sum_time = sum_time + (endTime - startTime);
                }
                else {
                    first_ini_time = endTime - startTime;
                }
//                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
                flag = false;
                continue;
            }
            
        }
        
        long avg_time = sum_time / 100;
        System.out.println("第一次初始化缓存花费时间：" + first_ini_time + " ms");
        System.out.println("100次请求平均时间为 ： " + avg_time + " ms");
        
        //保持长连接
        System.in.read();
    }
    
    
    
    private static void getMission(String beanName) {
        DemoProviderService demoService = (DemoProviderService) context.getBean(beanName);
        List<String> missions = demoService.getMission();
        if(missions != null) {
            for (String miss : missions) {
                System.out.println(miss);
            }
        }
    }
    private static void getAnnotationMission(String beanName) {
        DemoProviderAnnotationService demoProviderAnnotationService = (DemoProviderAnnotationService) context.getBean(beanName);
        List<String> missionAnnotations = demoProviderAnnotationService.getMissionAnnotation();
        if(missionAnnotations != null) {
            for (String missAnno : missionAnnotations) {
                System.out.println(missAnno);
            }
        }
    }
}
