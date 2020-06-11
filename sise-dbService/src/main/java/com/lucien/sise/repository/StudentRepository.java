package com.lucien.sise.repository;

import com.lucien.sise.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 17:52
 */
public interface StudentRepository extends JpaRepository<Student, String> {
    List<Student> findByCid(String cid);
}
