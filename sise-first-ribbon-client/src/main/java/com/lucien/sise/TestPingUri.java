package com.lucien.sise;

import com.netflix.client.ClientFactory;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.Server;
import com.netflix.niws.client.http.RestClient;

import java.io.IOException;
import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 10:13
 */
public class TestPingUri {
    public static void main(String[] args) throws InterruptedException, IOException {
//        BaseLoadBalancer Ib = new BaseLoadBalancer();
//        List<Server> servers = new ArrayList<>();
//        servers.add(new Server("localhost", 8001));
//        servers.add(new Server("localhost", 8888));
//        Ib.addServers(servers);
//        Ib.setPing(new PingUrl());
//        Ib.setPingInterval(2);
//        Thread.sleep(6000);
//        for (Server server : Ib.getAllServers()) {
//            System.out.println(server.getHostPort() + " State:" + server.isAlive());
//        }

        ConfigurationManager.loadPropertiesFromResources("application.properties");
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        Thread.sleep(6000);
        List<Server> servers = client.getLoadBalancer().getAllServers();
        System.out.println(servers.size());
        for (Server server : servers) {
            System.out.println(server.getHostPort() + " State:" + server.isAlive());
        }
    }
}
