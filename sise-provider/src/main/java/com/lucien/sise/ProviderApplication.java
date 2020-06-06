package com.lucien.sise;

import com.lucien.sise.service.SendService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 15:47
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableBinding(SendService.class)
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
