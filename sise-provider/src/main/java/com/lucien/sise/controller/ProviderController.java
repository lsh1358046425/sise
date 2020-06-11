package com.lucien.sise.controller;

import com.alibaba.fastjson.JSON;
import com.lucien.sise.entity.Student;
import com.lucien.sise.entity.User;
import com.lucien.sise.service.SendService;
import com.lucien.sise.service.DBServiceClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 15:51
 */

@RestController
public class ProviderController {
    @Autowired
    private SendService sendService;
    @Autowired
    private DBServiceClientService DBServiceClientService;

    @RequestMapping(value = "/send/{uid}", method = RequestMethod.GET)
    public String sendRequest(@PathVariable("uid") String uid){
        User user = DBServiceClientService.selectUser(uid);
        String info = user.getUid() + " " + user.getUsername();
        Message message = MessageBuilder.withPayload(info.getBytes()).build();
        sendService.sendOrder().send(message);
        return "SUCCESS";
    }

    @RequestMapping(value = "/stu/send/{cid}", method = RequestMethod.GET)
    public String sendStuRequest(@PathVariable("cid") String cid){
        List<Student> students = DBServiceClientService.selectStudentByCid(cid);
        Message message = MessageBuilder.withPayload(JSON.toJSONBytes(students)).build();
        sendService.sendStu().send(message);
        return "SUCCESS";
    }
}
