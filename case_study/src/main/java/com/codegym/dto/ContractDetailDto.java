package com.codegym.dto;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;

import javax.validation.constraints.Min;

public class ContractDetailDto {
    private int contractDetailId;
    private Contract contract;
    private AttachService attachService;
    @Min(value = 0, message = "Quantity must be positive")
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(Contract contract, AttachService attachService, int quantity) {
        this.contract = contract;
        this.attachService = attachService;
        this.quantity = quantity;
    }

    public int getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(int contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
