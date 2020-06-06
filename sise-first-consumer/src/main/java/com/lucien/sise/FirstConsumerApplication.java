package com.lucien.sise;

import com.lucien.sise.service.ReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 16:23
 */

@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class FirstConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstConsumerApplication.class, args);
    }

    @StreamListener("myInput")
    public void receive(byte[] bytes){
        System.out.println("FirstConsumer接收到消息：" + new String(bytes));
    }
}
