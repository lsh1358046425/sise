package sise.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sise.config.ribbon.MyLoadBalanced;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:58
 */

@RestController
@Configuration
public class FirstController {
    private static final String REST_URL_PREFIX = "http://FIRST-PROVIDER";
    @Bean
    @MyLoadBalanced
    public RestTemplate getMyRestTemplate(){
        return new RestTemplate();
    }

    @GetMapping("/router")
    public String router(){
        return getMyRestTemplate().getForObject(REST_URL_PREFIX+"/hello", String.class);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
}
