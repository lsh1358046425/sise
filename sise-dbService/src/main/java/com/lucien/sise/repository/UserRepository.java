package com.lucien.sise.repository;

import com.lucien.sise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/4 14:15
 */
public interface UserRepository extends JpaRepository<User, String> {
}
