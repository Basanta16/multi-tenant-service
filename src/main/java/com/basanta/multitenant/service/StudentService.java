package com.basanta.multitenant.service;

import com.basanta.multitenant.pojo.StudentPojo;
import java.util.List;

public interface StudentService {

    Integer saveStudent(StudentPojo studentPojo);
    StudentPojo getStudentById(Integer id) throws Exception;
    List<StudentPojo> getAllStudent();
}
