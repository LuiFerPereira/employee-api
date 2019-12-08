package com.masglobal.consulting.employees.mapper;

import com.masglobal.consulting.employees.contract.EmployeeDTO;
import com.masglobal.consulting.employees.contract.RoleDTO;
import com.masglobal.consulting.employees.domain.model.HourlySalaryEmployee;
import com.masglobal.consulting.employees.domain.model.MonthlySalaryEmployee;
import com.masglobal.consulting.employees.domain.model.Role;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {
        factory.classMap(Role.class, RoleDTO.class).byDefault().register();
        factory.classMap(HourlySalaryEmployee.class, EmployeeDTO.class).byDefault().register();
        factory.classMap(MonthlySalaryEmployee.class, EmployeeDTO.class).byDefault().register();
    }
}
