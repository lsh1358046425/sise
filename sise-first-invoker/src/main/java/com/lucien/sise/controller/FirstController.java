package com.lucien.sise.controller;

import com.lucien.sise.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:58
 */

@RestController
public class FirstController {
    private static final String REST_URL_PREFIX = "http://FIRST-PROVIDER";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/router")
    public Person router(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/person/9001", Person.class);
    }
}
