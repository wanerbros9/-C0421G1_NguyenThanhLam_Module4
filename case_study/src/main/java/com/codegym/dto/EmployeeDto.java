package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.employee.Division;
import com.codegym.model.entity.employee.EducationDegree;
import com.codegym.model.entity.employee.Position;

import javax.validation.constraints.*;
import java.util.Set;

public class EmployeeDto {
    private int employeeId;
    @NotEmpty(message = "Name must not be empty")
    private String employeeName;
    @NotEmpty(message = "Birth day must not be empty")
    private String employeeBirthday;
    @NotEmpty(message = "Id card must not be empty")
    private String employeeIdCard;
    @Min(value = 1, message = "Salary must positive")
    private double employeeSalary;
    @Pattern(regexp = "^(849[0|1]|09[0|1])+([0-9]{7})\\b$", message = "Wrong phone format")
    private String employeePhone;
    @Email(message = "Wrong email format")
    private String employeeEmail;
    @NotEmpty(message = "Address must not be empty")
    private String employeeAddress;
    private Set<Contract> contracts;
    private EducationDegree educationDegree;
    private Division division;
    private Position position;

    public EmployeeDto() {
    }

    public EmployeeDto(String employeeName, String employeeBirthday, String employeeIdCard, double employeeSalary, String employeePhone, String employeeEmail, String employeeAddress, Set<Contract> contracts, EducationDegree educationDegree, Division division, Position position) {
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
        this.contracts = contracts;
        this.educationDegree = educationDegree;
        this.division = division;
        this.position = position;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}

