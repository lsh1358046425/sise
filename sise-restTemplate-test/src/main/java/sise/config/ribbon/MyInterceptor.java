package sise.config.ribbon;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 18:22
 */
public class MyInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        System.out.println("======自定义拦截器实现");
        System.out.println("======原来的URI" + httpRequest.getURI());
        MyHttpRequest request = new MyHttpRequest(httpRequest);
        System.out.println("======拦截后的URI" + request.getURI());
        return clientHttpRequestExecution.execute(request, bytes);
    }
}
