package com.lucien.sise;

import com.lucien.sise.entity.Person;
import com.lucien.sise.entity.Result;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/4/9 18:08
 */
public interface PersonClient {
    @RequestLine("GET /person/{personId}")
    Person findById(@Param("personId") Integer personId);

    @RequestLine("POST /person/create")
    @Headers("Content-Type: application/json")
    String createPerson(Person person);

    @RequestLine("POST /person/createXML")
    @Headers("Content-Type: application/xml")
    Result createPersonXML(Person person);
}
