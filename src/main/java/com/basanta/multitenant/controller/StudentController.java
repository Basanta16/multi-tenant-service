package com.basanta.multitenant.controller;


import com.basanta.multitenant.entity.Student;
import com.basanta.multitenant.pojo.StudentPojo;
import com.basanta.multitenant.response.GlobalApiResponse;
import com.basanta.multitenant.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController extends BaseController {

    private final StudentService studentService;


    @PostMapping
    public GlobalApiResponse save(@RequestBody StudentPojo studentPojo) {
        return successResponse(customMessageSource
                .get("save succesfullly"), studentService.saveStudent(studentPojo));
    }

    @GetMapping("/{id}")
    public GlobalApiResponse getStudent(@PathVariable("id") Integer id) throws Exception {
        return successResponse(customMessageSource
                .get("get succesfullly"), studentService.getStudentById(id));
    }

    @GetMapping
    public GlobalApiResponse getAllStudent() {
        return successResponse(customMessageSource
                .get("get list succesfullly"), studentService.getAllStudent());
    }
}
