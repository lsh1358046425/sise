package com.lucien.sise;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lucien.sise.entity.Student;
import com.lucien.sise.service.ReceiveService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 19:15
 */

@SpringBootApplication
@EnableBinding(ReceiveService.class)
public class ThirdConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ThirdConsumerApplication.class, args);
    }

    @StreamListener("myInput")
    public void receive(byte[] bytes){
        System.out.println("ThirdConsumer接收到消息：" + new String(bytes));
    }

    @StreamListener("stu")
    public void receiveStu(byte[] bytes){
        System.out.println("ThirdConsumer接收到消息");
        String s = new String(bytes);
        List<Student> students = JSON.parseArray(s, Student.class);
        students.sort((o1, o2) -> o2.getRchinese() - o1.getRchinese());
        System.out.println("语文最高分学生：");
        System.out.println(JSON.toJSONString(students.get(0), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        students.sort((o1, o2) -> o2.getRmath() - o1.getRmath());
        System.out.println("数学最高分学生：");
        System.out.println(JSON.toJSONString(students.get(0), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
        students.sort((o1, o2) -> o2.getRenglish() - o1.getRenglish());
        System.out.println("英语最高分学生：");
        System.out.println(JSON.toJSONString(students.get(0), SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteDateUseDateFormat));
    }
}
