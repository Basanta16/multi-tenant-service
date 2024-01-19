package com.basanta.multitenant.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
