package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.customer.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class CustomerDto {
    private int customerId;
    private Set<Contract> contracts;
    private CustomerType customerType;
    @NotEmpty(message = "Name must not be empty")
    private String customerName;
    @NotEmpty(message = "Birth day must not be empty")
    private String customerBirthday;
    private Boolean customerGender;
    @NotEmpty(message = "Id card must not be empty")
    private String customerIdCard;
    @Pattern(regexp = "^(849[0|1]|09[0|1])+([0-9]{7})\\b$", message = "Wrong phone format")
    private String customerPhone;
    @Email(message = "Wrong email format")
    private String customerEmail;
    @NotEmpty(message = "Address must not be empty")
    private String customerAddress;
    @Pattern(regexp = "^KH-\\d{4}$", message = "Incorrect, try again." +
            "\n Ex:KH-xxxx. x is number")
    private String customerCode;

    public CustomerDto() {
    }

    public CustomerDto(Set<Contract> contracts, CustomerType customerType, String customerName, String customerBirthday, Boolean customerGender, String customerIdCard, String customerPhone, String customerEmail, String customerAddress, String customerCode) {
        this.contracts = contracts;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerCode = customerCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public Boolean getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(Boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
}
