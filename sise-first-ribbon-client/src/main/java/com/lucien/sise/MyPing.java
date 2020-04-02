package com.lucien.sise;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 9:54
 */
public class MyPing implements IPing {

    @Override
    public boolean isAlive(Server server) {
        System.out.println("This is My Ping class: " + server.getHostPort());
        return true;
    }
}
