package com.lucien.sise.service;

import com.lucien.sise.entity.Student;
import com.lucien.sise.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 17:59
 */

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findStudentByCid(String cid){
        return studentRepository.findByCid(cid);
    }
}
