package com.lucien.sise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 15:50
 */

@SpringBootApplication
@EnableEurekaClient
public class DBServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DBServiceApplication.class, args);
    }
}
