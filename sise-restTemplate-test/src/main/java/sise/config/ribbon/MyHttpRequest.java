package sise.config.ribbon;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/2 18:16
 */
public class MyHttpRequest implements HttpRequest {
    private HttpRequest httpRequest;

    public MyHttpRequest(HttpRequest httpRequest){
        this.httpRequest = httpRequest;
    }

    @Override
    public HttpMethod getMethod() {
        return httpRequest.getMethod();
    }

    @Override
    public String getMethodValue() {
        return null;
    }

    @Override
    public URI getURI() {
        try {
            String oldUri = httpRequest.getURI().toString();
            URI newUri = new URI("http://localhost:8080/hello");
            return newUri;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return httpRequest.getURI();
    }

    @Override
    public HttpHeaders getHeaders() {
        return httpRequest.getHeaders();
    }
}
