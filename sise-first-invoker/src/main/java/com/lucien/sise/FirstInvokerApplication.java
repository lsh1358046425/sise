package com.lucien.sise;

import com.lucien.sise.config.ribbon.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:54
 */

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "first-provider", configuration = RibbonConfig.class)
public class FirstInvokerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstInvokerApplication.class,args);
    }
}
