package com.basanta.multitenant.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "data_source_config")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class DataSourceConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "data_source_config_seq_gen")
    @SequenceGenerator(name = "data_source_config_seq_gen", sequenceName = "data_source_config_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "tenant_url")
    private String tenantUrl;

    @Column(name = "tenant_username")
    private String username;

    @Column(name = "tenant_password")
    private String password;


    @Column(name = "driver_class_name")
    private String driverClassName;

    @Column(name = "initialize")
    private boolean initialize;
}
