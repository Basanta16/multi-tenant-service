package com.basanta.multitenant.pojo;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StudentPojo {


    private Integer id;
    private String tenantId;
    private String studentName;
}
