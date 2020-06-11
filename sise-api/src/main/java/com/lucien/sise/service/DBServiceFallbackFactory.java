package com.lucien.sise.service;

import com.lucien.sise.entity.Student;
import com.lucien.sise.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 22:25
 */

@Component
public class DBServiceFallbackFactory implements FallbackFactory<DBServiceClientService> {

    @Override
    public DBServiceClientService create(Throwable throwable) {
        return new DBServiceClientService() {
            @Override
            public Map<String, String> save(User user) {
                System.out.println("error");
                return null;
            }

            @Override
            public User selectUser(String uid) {
                System.out.println("error");
                return null;
            }

            @Override
            public List<Student> selectStudentByCid(String cid) {
                System.out.println("error");
                return null;
            }
        };
    }
}
