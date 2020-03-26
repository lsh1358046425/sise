package com.lucien.sise.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/3/25 20:50
 */

@RestController
public class HealthController {
    public static Boolean canVisitDb = false;

    @GetMapping("/db/{state}")
    public String setConnectState(@PathVariable Boolean state){
        canVisitDb=state;
        System.out.println("=========="+canVisitDb);
        return "Now database is state:"+canVisitDb;
    }
}
