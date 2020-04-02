package com.lucien.sise;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/26 18:18
 */
public class ChooseServerTest {
    public static void main(String[] args) {
//        ILoadBalancer balancer = new BaseLoadBalancer();
        BaseLoadBalancer balancer = new BaseLoadBalancer();
        balancer.setRule(new  MyRule(balancer));
        List<Server> servers = new ArrayList<>();
        servers.add(new Server("localhost",8001));
        servers.add(new Server("localhost",8005));
        balancer.addServers(servers);
        for (int i = 0; i < 6; i++) {
            Server server = balancer.chooseServer(null);
            System.out.println(server);
        }
    }
}
