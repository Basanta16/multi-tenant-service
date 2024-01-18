package com.basanta.multitenant.service.impl;

import com.basanta.multitenant.entity.Student;
import com.basanta.multitenant.exception.AppException;
import com.basanta.multitenant.pojo.StudentPojo;
import com.basanta.multitenant.repo.StudentRepository;
import com.basanta.multitenant.service.StudentService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public Integer saveStudent(StudentPojo studentPojo) {
        Student student = Student.builder()
                .studentName(studentPojo.getStudentName())
                .tenantId(studentPojo.getTenantId()).build();
       return studentRepository.save(student).getId();
    }

    @Override
    public StudentPojo getStudentById(Integer id) throws AppException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new AppException("Id not found"));
        return StudentPojo.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .tenantId(student.getTenantId()).build();
    }

    @Override
    public List<StudentPojo> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
       return studentList.stream()
                .map(student -> {
                    StudentPojo studentPojo = StudentPojo.builder()
                            .id(student.getId())
                            .studentName(student.getStudentName())
                            .tenantId(student.getTenantId()).build();
                    return studentPojo;
                }).collect(Collectors.toList());
    }
}
