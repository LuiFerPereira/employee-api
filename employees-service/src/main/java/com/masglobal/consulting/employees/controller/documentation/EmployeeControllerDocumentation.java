package com.masglobal.consulting.employees.controller.documentation;

import com.masglobal.consulting.employees.contract.EmployeeDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api(
        value = "Employee controller.",
        tags = "Employee controller",
        produces = "application/json",
        consumes = "application/json",
        description = "This controller allow to get employees filtering by identifier")
public interface EmployeeControllerDocumentation {

    @ApiOperation(
            value = "Get all employees from remote cloud service",
            notes = "Get all employees from Azure Mas Global",
            response = EmployeeDTO.class)
    ResponseEntity<List<EmployeeDTO>> getAllEmployees();

    @ApiOperation(
            value = "Get one employee from remote cloud service",
            notes = "Get all employees from Azure Mas Global, after a filter expression is apply",
            response = EmployeeDTO.class)
    ResponseEntity<EmployeeDTO> getEmployeesById(@PathVariable String id);
}
