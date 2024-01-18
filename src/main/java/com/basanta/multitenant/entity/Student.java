package com.basanta.multitenant.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq_gen")
    @SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "tenant_id")
    private String tenantId;

    @Column(name = "student_name")
    private String studentName;
}
