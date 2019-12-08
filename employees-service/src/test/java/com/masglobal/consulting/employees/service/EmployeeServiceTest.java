package com.masglobal.consulting.employees.service;

import com.masglobal.consulting.employees.domain.model.Employee;
import com.masglobal.consulting.employees.domain.model.enums.ContractType;
import com.masglobal.consulting.employees.domain.remote.model.EmployeeRemoteDTO;
import com.masglobal.consulting.employees.remote.connector.EmployeeApiConnector;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    private EmployeeApiConnector employeeApiConnector = Mockito.mock(EmployeeApiConnector.class);

    private EmployeeService employeeService = new EmployeeService(employeeApiConnector);

    @Test
    void shouldReturnAListWhenCallGetAllEmployees() {

        // mocks
        final List<EmployeeRemoteDTO> mockList = createMockList(10);
        doAnswer(invocationOnMock -> {
            return mockList;
        }).when(employeeApiConnector).getAllEmployee();

        // execute
        final List<Employee> allEmployees = employeeService.getAllEmployees();

        // asserts
        verify(employeeApiConnector, times(1)).getAllEmployee();
        assertEquals(mockList.size(), allEmployees.size());
        assertTrue(allEmployees.stream().allMatch(employee ->employee.getAnnualSalary().doubleValue() > 0));

    }

    @Test
    void shouldReturnAEmployeeWhenCallGetEmployeesById() {

        // mocks
        final List<EmployeeRemoteDTO> mockList = createMockList(10);
        doAnswer(invocationOnMock -> {
            return mockList;
        }).when(employeeApiConnector).getAllEmployee();

        // execute
        final Optional<Employee> employee = employeeService.getEmployeesById(10L);

        // asserts
        verify(employeeApiConnector, times(1)).getAllEmployee();
        assertTrue(employee.isPresent());
        assertTrue(employee.get().getAnnualSalary().doubleValue() > 0);
    }

    @Test
    void shouldReturnAEmptyOptionalWhenCallGetEmployeesByIdAndNotFound() {

        // mocks
        final List<EmployeeRemoteDTO> mockList = createMockList(5);
        doAnswer(invocationOnMock -> {
            return mockList;
        }).when(employeeApiConnector).getAllEmployee();

        // execute
        final Optional<Employee> employee = employeeService.getEmployeesById(20L);

        // asserts
        verify(employeeApiConnector, times(1)).getAllEmployee();
        assertTrue(employee.isEmpty());
    }

    private List<EmployeeRemoteDTO> createMockList(int size) {

        List<EmployeeRemoteDTO> employeeRemoteDTOS = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            EmployeeRemoteDTO employeeRemoteDTO = new EmployeeRemoteDTO();
            employeeRemoteDTO.setId((long) (i + 1));
            employeeRemoteDTO.setName(RandomStringUtils.randomAlphabetic(5));
            employeeRemoteDTO.setContractTypeName( i % 2 == 0 ? ContractType.HourlySalaryEmployee.name()
                    : ContractType.MonthlySalaryEmployee.name());
            employeeRemoteDTO.setHourlySalary(RandomUtils.nextInt(1000, 3000));
            employeeRemoteDTO.setMonthlySalary(RandomUtils.nextInt(5000, 8000));
            employeeRemoteDTO.setRoleId(i % 2 == 0 ? 1L : 2L);
            employeeRemoteDTO.setName( employeeRemoteDTO.getRoleId() == 1L ? "Administrator" : "Contractor");
            employeeRemoteDTO.setRoleDescription(RandomStringUtils.randomAlphabetic(10));
            employeeRemoteDTOS.add(employeeRemoteDTO);
        }
        return employeeRemoteDTOS;
    }
}