package com.lucien.sise;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 17:26
 */
public class CxfClient {
    public static void main(String[] args) throws IOException {
        WebClient client = WebClient.create("http://localhost:8080/person/1");
        Response response = client.get();
        InputStream stream = (InputStream) response.getEntity();
        String content = IOUtils.readStringFromStream(stream);
        System.out.println(content);
    }
}
