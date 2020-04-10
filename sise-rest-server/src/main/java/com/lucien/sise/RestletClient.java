package com.lucien.sise;

import org.restlet.data.MediaType;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 17:50
 */
public class RestletClient {
    public static void main(String[] args) throws IOException {
        ClientResource resource = new ClientResource("http://localhost:8080/person/1");
        Representation representation = resource.get(MediaType.APPLICATION_JSON);
        JacksonRepresentation jacksonRepresentation = new JacksonRepresentation(representation, HashMap.class);
        Map result = (HashMap) jacksonRepresentation.getObject();
        System.out.println(result.get("personId") + "-" + result.get("personName") + "-" + result.get("personAge") + "-" + result.get("message"));
    }
}
