package com.lucien.sise.service;

import com.lucien.sise.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 15:02
 */

@FeignClient("dbService")
public interface UserClientService {
    @PostMapping("/save")
    public Map<String, String> save(@RequestBody User user);

    @GetMapping("/stuinfo/{uid}")
    public User selectUser(@PathVariable("uid") String uid);
}
