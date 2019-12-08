package com.masglobal.consulting.employees.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.masglobal.consulting.employees.domain.model.enums.ContractType;
import com.masglobal.consulting.employees.domain.serializer.BigDecimalSerializer;

import java.math.BigDecimal;

public interface Employee {

    ContractType getContractType();
    @JsonSerialize(using = BigDecimalSerializer.class)
    BigDecimal getAnnualSalary();
}
