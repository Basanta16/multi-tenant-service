package com.basanta.multitenant.service;

import com.basanta.multitenant.exception.AppException;
import com.basanta.multitenant.pojo.StudentPojo;
import java.util.List;

public interface StudentService {

    Integer saveStudent(StudentPojo studentPojo);
    StudentPojo getStudentById(Integer id) throws AppException;
    List<StudentPojo> getAllStudent();
}
