package com.masglobal.consulting.employees.domain.factory;

import com.masglobal.consulting.employees.domain.model.Employee;
import com.masglobal.consulting.employees.domain.model.HourlySalaryEmployee;
import com.masglobal.consulting.employees.domain.model.MonthlySalaryEmployee;
import com.masglobal.consulting.employees.domain.model.Role;
import com.masglobal.consulting.employees.domain.model.enums.ContractType;
import com.masglobal.consulting.employees.domain.remote.model.EmployeeRemoteDTO;

public class EmployeeFactory {

    /**
     * Create a new Employee based on remote DTO and the contract type.
     * The annual salary will calculate by contract type.
     *
     * @param employeeRemoteDTO a remote DTO from external EmployeeApi
     * @return
     */
    public static Employee createNew(EmployeeRemoteDTO employeeRemoteDTO) {

        if (employeeRemoteDTO.getContractTypeName().equals(ContractType.HourlySalaryEmployee.name())) {
            return new HourlySalaryEmployee(employeeRemoteDTO.getId()
                    , employeeRemoteDTO.getName()
                    , createRole(employeeRemoteDTO.getRoleId(), employeeRemoteDTO.getRoleName(), employeeRemoteDTO.getRoleDescription())
                    , employeeRemoteDTO.getHourlySalary());
        }else {
            return new MonthlySalaryEmployee(employeeRemoteDTO.getId()
                    , employeeRemoteDTO.getName()
                    , createRole(employeeRemoteDTO.getRoleId(), employeeRemoteDTO.getRoleName(), employeeRemoteDTO.getRoleDescription())
                    , employeeRemoteDTO.getMonthlySalary());
        }
    }

    private static Role createRole(Long id, String name, String description) {
        return new Role(id, name, description);
    }
}
