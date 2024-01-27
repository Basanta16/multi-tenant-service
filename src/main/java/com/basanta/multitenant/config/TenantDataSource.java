package com.basanta.multitenant.config;

import com.basanta.multitenant.repo.DataSourceConfigRepository;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;

public class TenantDataSource implements Serializable {

    private HashMap<String, DataSource> dataSourceHashMap = new HashMap<>();

    @Autowired
    private DataSourceConfigRepository dataSOurceConfigRepository;


    public DataSource getDataSource(String name){
        if(dataSourceHashMap.get(name) != null){
            return dataSourceHashMap.get(name);
        }
        DataSource dataSource = createDataSource(name);
        if(dataSource != null){
            dataSourceHashMap.put(name, dataSource);
        }
        return dataSource;
    }

    @PostConstruct
    public Map<String, DataSource> getAll(){
        List<DataSourceConfig> configList = dataSOurceConfigRepository.findAll();
        Map<String, DataSource> result = new HashMap<>();
        for (DataSourceConfig dataSourceConfig : configList){
            DataSource dataSource = getDataSource(dataSourceConfig.getName());
            result.put(dataSourceConfig.getName(), dataSource);
        }
        return result;
    }


    private DataSource createDataSource(String name){
        DataSourceConfig config = dataSOurceConfigRepository.findByName(name);
        if(config != null){
            DataSourceBuilder dataSourceBuilder = DataSourceBuilder
                    .create().driverClassName(config.getDriverClassName())
                    .username(config.getUsername())
                    .password(config.getPassword())
                    .url(config.getTenantUrl());
            DataSource dataSource = dataSourceBuilder.build();
            return dataSource;


        }
        return null;
    }
}
