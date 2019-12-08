package com.masglobal.consulting.employees.remote.connector;

import com.masglobal.consulting.employees.domain.remote.model.EmployeeRemoteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeApiConnector implements EmployeeApi {

    private final Logger LOGGER = LoggerFactory.getLogger(EmployeeApiConnector.class);

    private final RestTemplate restTemplate;
    final String EXTERNAL_EMPLOYEE_API_URI = "http://masglobaltestapi.azurewebsites.net/api/employees";

    @Autowired
    public EmployeeApiConnector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Optional<EmployeeRemoteDTO> getEmployeeById(Long id) {
        throw new UnsupportedOperationException("External EmployeeApi not allow this operation");
    }

    @Override
    public List<EmployeeRemoteDTO> getAllEmployee() {
        LOGGER.info("Calling an external service URI: {}", EXTERNAL_EMPLOYEE_API_URI);
        ResponseEntity<EmployeeRemoteDTO[]> response = restTemplate.getForEntity(EXTERNAL_EMPLOYEE_API_URI, EmployeeRemoteDTO[].class);
        return Arrays.asList(response.getBody());
    }
}
