package com.lucien.sise.service;

import com.lucien.sise.entity.User;
import com.lucien.sise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 14:28
 */

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    public User selectByKey(String uid){
        return userRepository.findById(uid).get();
    }
}
