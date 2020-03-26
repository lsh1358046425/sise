package com.lucien.sise.health;

import com.lucien.sise.controller.HealthController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/25 20:59
 */

@Component
public class MyHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        if (HealthController.canVisitDb){
            return new Health.Builder(Status.UP).build();
        }else {
            return new Health.Builder(Status.DOWN).build();
        }
    }
}
