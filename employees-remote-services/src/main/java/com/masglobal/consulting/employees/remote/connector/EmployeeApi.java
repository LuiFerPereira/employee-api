package com.masglobal.consulting.employees.remote.connector;

import com.masglobal.consulting.employees.domain.remote.model.EmployeeRemoteDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeApi {

    Optional<EmployeeRemoteDTO> getEmployeeById(Long id);

    List<EmployeeRemoteDTO> getAllEmployee();

}
