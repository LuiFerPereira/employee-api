package com.masglobal.consulting.employees.controller;

import com.google.common.base.Preconditions;
import com.masglobal.consulting.employees.contract.EmployeeDTO;
import com.masglobal.consulting.employees.controller.documentation.EmployeeControllerDocumentation;
import com.masglobal.consulting.employees.domain.model.Employee;
import com.masglobal.consulting.employees.service.EmployeeService;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController implements EmployeeControllerDocumentation {

    private EmployeeService employeeService;
    private MapperFacade mapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, MapperFacade mapper) {
        this.employeeService = employeeService;
        this.mapper = mapper;
    }

    /**
     * Get All employees endpoint
     *
     * @return Response with 200 http status code and with body a list of employees when exists.
     *         Otherwise, return 404 not found
     */
    @GetMapping(value = "/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        final List<Employee> employeeList = this.employeeService.getAllEmployees();

        if (employeeList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.mapAsList(employeeList, EmployeeDTO.class));
    }

    /**
     * @param id a numeric string for search a employee by identifier
     * @return Response with 200 http status code and with body a employees when exists one with the identifier.
     *         Otherwise, return 404 not found
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeesById(@PathVariable String id) {

        Preconditions.checkArgument(StringUtils.isNumeric(id), "must be required a valid numeric identifier");
        Preconditions.checkArgument(Long.parseLong(id) > 0, "must be required a valid numeric identifier");

        final Optional<Employee> employeeById = this.employeeService.getEmployeesById(Long.parseLong(id));
        if (employeeById.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mapper.map(employeeById.get(), EmployeeDTO.class));

    }
}
