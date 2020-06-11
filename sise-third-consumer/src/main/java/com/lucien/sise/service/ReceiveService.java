package com.lucien.sise.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 16:24
 */

public interface ReceiveService {
    @Input("myInput")
    SubscribableChannel myInput();

    @Input("stu")
    SubscribableChannel stu();
}
