package com.lucien.sise.config.ribbon;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 17:48
 */

public class RibbonConfig {
    @Bean
    public IRule getRule(){
        return new MyRule();
    }

    @Bean
    public IPing getPing(){
        return new MyPing();
    }
}
