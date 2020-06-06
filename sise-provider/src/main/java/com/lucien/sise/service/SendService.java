package com.lucien.sise.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Service;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 15:41
 */

@Service
public interface SendService {
    @Output("myInput")
    SubscribableChannel sendOrder();
}
