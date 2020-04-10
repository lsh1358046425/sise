package com.lucien.sise;

import com.lucien.sise.entity.Person;
import com.lucien.sise.entity.Result;
import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/10 20:41
 */
public class XMLTest {
    public static void main(String[] args) {
        JAXBContextFactory factory = new JAXBContextFactory.Builder().build();
        PersonClient client = Feign.builder().encoder(new JAXBEncoder(factory))
                .decoder(new JAXBDecoder(factory)).target(PersonClient.class, "http://localhost:8080/");
        Person person = new Person();
        person.setPersonId(1).setPersonName("Lucien").setPersonAge(30);
        Result xml = client.createPersonXML(person);
        System.out.println(xml.getMessage());
    }
}
