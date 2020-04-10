package com.lucien.sise;

import com.lucien.sise.entity.Person;
import feign.Feign;
import feign.gson.GsonEncoder;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/10 20:26
 */
public class EncoderTest {
    public static void main(String[] args) {
        PersonClient client = Feign.builder().encoder(new GsonEncoder())
                .target(PersonClient.class, "http://localhost:8080/");
        Person person = new Person();
        person.setPersonId(1).setPersonName("Lucien").setPersonAge(30);
        String response = client.createPerson(person);
        System.out.println(response);
    }
}
