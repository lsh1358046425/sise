package com.lucien.sise.controller;

import com.lucien.sise.entity.Person;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:58
 */

@RestController
@Configuration
public class FirstController {
    private static final String REST_URL_PREFIX = "http://FIRST-PROVIDER";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/router")
    public Person router(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/person/9001", Person.class);
    }

    @GetMapping("/health/router")
    public String healthRouter(){
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = new ArrayList<>();
        for (String service : services) {
            instances.addAll(discoveryClient.getInstances(service));
        }
        for (ServiceInstance instance : instances) {
            EurekaDiscoveryClient.EurekaServiceInstance eurekaServiceInstance= (EurekaDiscoveryClient.EurekaServiceInstance) instance;
            InstanceInfo info = eurekaServiceInstance.getInstanceInfo();
            System.out.println(info.getAppName()+"==="+info.getInstanceId()+"==="+info.getStatus());
        }
        return "OK";
    }
}
