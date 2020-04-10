package com.lucien.sise;

import com.lucien.sise.entity.Person;
import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 18:08
 */
public class PersonMain {
    public static void main(String[] args) {
        PersonClient client = Feign.builder().decoder(new GsonDecoder()).target(PersonClient.class, "http://localhost:8080/");
        Person person = client.findById(2);
        System.out.println(person.getPersonId());
        System.out.println(person.getPersonName());
        System.out.println(person.getPersonAge());
        System.out.println(person.getMessage());
    }
}
