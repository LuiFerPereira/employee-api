package com.masglobal.consulting.employees.contract;

import com.masglobal.consulting.employees.contract.enums.ContractTypeDTO;

public class EmployeeDTO extends PersonDTO {

    private ContractTypeDTO contractType;

    public ContractTypeDTO getContractType() {
        return contractType;
    }

    public void setContractType(ContractTypeDTO contractType) {
        this.contractType = contractType;
    }
}
