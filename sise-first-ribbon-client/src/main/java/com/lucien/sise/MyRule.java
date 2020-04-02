package com.lucien.sise;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 9:21
 */
public class MyRule implements IRule {
    private ILoadBalancer Ib;

    public MyRule(){}

    public MyRule(ILoadBalancer Ib){
        this.Ib = Ib;
    }

    @Override
    public Server choose(Object o) {
        List<Server> servers = Ib.getAllServers();
        return servers.get(0);
    }

    @Override
    public void setLoadBalancer(ILoadBalancer Ib) {
        this.Ib = Ib;
    }

    @Override
    public ILoadBalancer getLoadBalancer() {
        return this.Ib;
    }
}
