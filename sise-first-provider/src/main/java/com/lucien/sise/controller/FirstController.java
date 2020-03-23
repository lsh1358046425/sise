package com.lucien.sise.controller;

import com.lucien.sise.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/23 17:44
 */

@RestController
public class FirstController {
    @GetMapping("/person/{personId}")
    public Person findName(@PathVariable String personId){
        Person person = new Person();
        person.setPersonId(Integer.parseInt(personId)).setPersonAge(23).setPersonName("Lucien");
        return person;
    }
}
