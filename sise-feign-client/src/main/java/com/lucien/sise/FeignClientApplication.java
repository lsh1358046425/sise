package com.lucien.sise;

import feign.Feign;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 18:03
 */
public class FeignClientApplication {
    public static void main(String[] args) {
        HelloClient client = Feign.builder().target(HelloClient.class, "http://localhost:8080/");
        System.out.println(client.sayHello());
    }
}
