package com.basanta.multitenant.repo;

import com.basanta.multitenant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface  StudentRepository extends JpaRepository<Student, Integer> {


}
