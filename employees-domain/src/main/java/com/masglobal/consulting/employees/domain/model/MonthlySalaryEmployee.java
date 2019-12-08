package com.masglobal.consulting.employees.domain.model;

import com.masglobal.consulting.employees.domain.model.enums.ContractType;

import java.math.BigDecimal;

public class MonthlySalaryEmployee extends Person implements Employee {

    public MonthlySalaryEmployee(Long id, String name, Role role, double monthlySalary) {
        super(id, name, role, 0, monthlySalary);
    }

    @Override
    public BigDecimal calculateAnnualSalary() {
        return BigDecimal.valueOf(this.getMonthlySalary())
                .multiply(BigDecimal.valueOf(12L));
    }

    @Override
    public ContractType getContractType() {
        return ContractType.MonthlySalaryEmployee;
    }

    @Override
    public BigDecimal getAnnualSalary() {
        return calculateAnnualSalary();
    }
}
