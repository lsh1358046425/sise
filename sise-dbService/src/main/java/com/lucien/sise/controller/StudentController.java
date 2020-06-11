package com.lucien.sise.controller;

import com.lucien.sise.entity.Student;
import com.lucien.sise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lucien
 * @version 1.0
 * @date 2020/6/11 17:59
 */

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/stuListByCid/{cid}")
    public List<Student> selectStudentByCid(@PathVariable("cid") String cid){
        return studentService.findStudentByCid(cid);
    }
}
