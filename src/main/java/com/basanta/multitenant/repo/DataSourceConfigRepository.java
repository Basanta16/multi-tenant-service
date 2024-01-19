package com.basanta.multitenant.repo;

import com.basanta.multitenant.config.DataSourceConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataSourceConfigRepository extends JpaRepository<DataSourceConfig, Integer> {

    DataSourceConfig findByName(String name);
}
