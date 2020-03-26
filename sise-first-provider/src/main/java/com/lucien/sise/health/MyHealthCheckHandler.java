package com.lucien.sise.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/25 21:04
 */

@Component
public class MyHealthCheckHandler implements HealthCheckHandler {
    @Autowired
    private MyHealthIndicator myHealthIndicator;

    @Override
    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
        Status status = myHealthIndicator.health().getStatus();
        if (status.equals(Status.UP)){
            System.out.println("数据库正常连接");
            return InstanceInfo.InstanceStatus.UP;
        }else {
            System.out.println("数据库无法连接");
            return InstanceInfo.InstanceStatus.DOWN;
        }
    }
}
