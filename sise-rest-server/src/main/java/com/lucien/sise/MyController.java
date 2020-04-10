package com.lucien.sise;

import com.lucien.sise.entity.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 17:21
 */

@RestController
public class MyController {
    @RequestMapping("/person/{personId}")
    public Person findPerson(@PathVariable Integer personId, HttpServletRequest request){
        Person person = new Person();
        person.setPersonId(personId).setPersonAge(23)
                .setPersonName("Lucien").setMessage(request.getRequestURL().toString());
        return person;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Cloud!";
    }

    @RequestMapping(value = "/person/create", consumes = MediaType.APPLICATION_JSON)
    public String createPerson(@RequestBody Person person) {
        System.out.println(person.getPersonName() + "-" + person.getPersonAge());
        return "Success, PersonId: " + person.getPersonId();
    }

    @RequestMapping(value = "/person/createXML", consumes = MediaType.APPLICATION_XML, produces = MediaType.APPLICATION_XML)
    public String createXMLPerson(@RequestBody Person person) {
        System.out.println(person.getPersonName() + "-" + person.getPersonAge());
        return "<result><message>success</message></result>";
    }
}
