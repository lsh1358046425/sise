package com.lucien.sise;

import com.lucien.sise.service.ReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 19:15
 */

@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class ThirdConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdConsumerApplication.class, args);
    }

    @StreamListener("myInput")
    public void receive(byte[] bytes){
        System.out.println("ThirdConsumer接收到消息：" + new String(bytes));
    }
}
