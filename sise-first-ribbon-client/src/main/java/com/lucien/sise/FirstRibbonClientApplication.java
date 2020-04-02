package com.lucien.sise;

import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.niws.client.http.RestClient;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 9:46
 */

public class FirstRibbonClientApplication {
    public static void main(String[] args) throws Exception {
        ConfigurationManager.loadPropertiesFromResources("application.properties");
        RestClient client = (RestClient) ClientFactory.getNamedClient("my-client");
        HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
        for (int i = 0; i < 6; i++) {
            HttpResponse response = client.executeWithLoadBalancer(request);
            String result = response.getEntity(String.class);
            System.out.println(result);
        }
    }
}
