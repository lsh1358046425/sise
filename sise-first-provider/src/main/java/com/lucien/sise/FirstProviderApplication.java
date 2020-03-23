package com.lucien.sise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:43
 */

@SpringBootApplication
@EnableEurekaClient
public class FirstProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstProviderApplication.class,args);
    }
}