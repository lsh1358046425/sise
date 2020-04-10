package com.lucien.sise;

import feign.RequestLine;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 18:02
 */
public interface HelloClient {
    @RequestLine("GET /hello")
    String sayHello();
}
