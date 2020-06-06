package com.lucien.sise.controller;

import com.lucien.sise.entity.User;
import com.lucien.sise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 14:35
 */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public Map<String, String> save(@RequestBody User user){
        userService.save(user);
        HashMap<String, String> map = new HashMap<>();
        map.put("code", "success");
        return map;
    }

    @GetMapping("/stuinfo/{uid}")
    public User selectUser(@PathVariable("uid") String uid){
        return userService.selectByKey(uid);
    }
}
