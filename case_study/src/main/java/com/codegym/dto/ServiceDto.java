package com.codegym.dto;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.service.RentType;
import com.codegym.model.entity.service.ServiceType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

public class ServiceDto {
    private int serviceId;
    @NotEmpty(message = "Name must not be empty")
    private String serviceName;
    @Min(value = 0, message = "Area must be positive")
    private int serviceArea;
    @Min(value = 0, message = "Cost must be positive")
    private double serviceCost;
    @Min(value = 0, message = "People must be positive")
    private int serviceMaxPeople;
    private Set<Contract> contracts;
    private RentType rentType;
    private ServiceType serviceType;
    @NotEmpty(message = "Standard must not be empty")
    private String standardRoom;
    @NotEmpty(message = "Standard must not be empty")
    private String descriptionOtherConvenience;
    @Min(value = 0, message = "Pool area must be positive")
    private int poolArea;
    @Min(value = 0, message = "Number of floor must be positive")
    private int numberOfFloors;
    @Pattern(regexp = "^DV-\\d{4}$", message = "Incorrect, try again." +
            "\n Ex:DV-xxxx. x is number")
    private String serviceCode;

    public ServiceDto() {
    }

    public ServiceDto(String serviceName, int serviceArea, double serviceCost, int serviceMaxPeople, Set<Contract> contracts, RentType rentType, ServiceType serviceType, String standardRoom, String descriptionOtherConvenience, int poolArea, int numberOfFloors, String serviceCode) {
        this.serviceName = serviceName;
        this.serviceArea = serviceArea;
        this.serviceCost = serviceCost;
        this.serviceMaxPeople = serviceMaxPeople;
        this.contracts = contracts;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.serviceCode = serviceCode;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public int getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(int serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}
