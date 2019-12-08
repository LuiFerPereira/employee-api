package com.masglobal.consulting.employees.service;

import com.masglobal.consulting.employees.domain.factory.EmployeeFactory;
import com.masglobal.consulting.employees.domain.model.Employee;
import com.masglobal.consulting.employees.remote.connector.EmployeeApiConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeApiConnector employeeApiConnector;

    @Autowired
    public EmployeeService(EmployeeApiConnector employeeApiConnector) {
        this.employeeApiConnector = employeeApiConnector;
    }

    /**
     * Get all employees using api connector to remote service.
     *
     * Complexity: O(n)
     *             A map expression is used for return a business object
     *
     * @return a list of employees
     */
    public List<Employee> getAllEmployees() {
        LOGGER.debug("Using EmployeeApi connector");
        return this.employeeApiConnector.getAllEmployee()
                .stream()
                .map(EmployeeFactory::createNew)
                .collect(Collectors.toList());
    }

    /**
     * Get all employees using api connector to remote service. After a filter
     * expression is apply.
     *
     * Complexity: O(n)
     *             The stream filtering uses iteration internally
     *
     * @param id is a numeric identifier used for filtering expression
     * @return an {@code Optional} with a present value if the specified {@param id}
     *         is found, otherwise an empty {@code Optional}
     */
    public Optional<Employee> getEmployeesById(Long id) {
        LOGGER.debug("Using EmployeeApi connector");
        return this.employeeApiConnector.getAllEmployee()
                .stream()
                .filter(employeeRemoteDTO -> employeeRemoteDTO.getId().equals(id))
                .map(EmployeeFactory::createNew)
                .reduce((a, b) -> null);
    }
}
