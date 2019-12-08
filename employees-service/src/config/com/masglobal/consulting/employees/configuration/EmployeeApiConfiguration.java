package com.masglobal.consulting.employees.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.support.DefaultConversionService;

public class EmployeeApiConfiguration {


    @Bean
    public DefaultConversionService defaultConversionService() {

        DefaultConversionService dcs = new DefaultConversionService();

        return dcs;
    }
}
