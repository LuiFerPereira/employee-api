package com.masglobal.consulting.employees.domain.model;

import com.masglobal.consulting.employees.domain.model.enums.ContractType;

import java.math.BigDecimal;

public class HourlySalaryEmployee extends Person implements Employee {

    public HourlySalaryEmployee(Long id, String name, Role role, double hourlySalary) {
        super(id, name, role, hourlySalary, 0);
    }

    @Override
    public ContractType getContractType() {
        return ContractType.HourlySalaryEmployee;
    }

    @Override
    public BigDecimal calculateAnnualSalary() {
        return BigDecimal.valueOf(this.getHourlySalary())
                .multiply(BigDecimal.valueOf(120L))
                .multiply(BigDecimal.valueOf(12L));
    }

    @Override
    public BigDecimal getAnnualSalary() {
        return calculateAnnualSalary();
    }
}
