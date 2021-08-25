package com.codegym.model.bean;

public class Health {
    private String name;
    private int yearBirth;
    private int gender;
    private String nationality;
    private String citizenId;
    private String travelInformation;
    private String vehicleNumber;
    private String seatNumber;
    private String departureDate;
    private String arriveDate;
    private String stayCity;
    private String homeCity;
    private String homeDistrict;
    private String homeWard;
    private String homeAddress;
    private int phoneNumber;
    private String email;
    private String[] symptom;
    private String[] exposure;

    public Health() {
    }

    public Health(String name, int yearBirth, int gender, String nationality, String citizenId, String travelInformation, String vehicleNumber, String seatNumber, String departureDate, String arriveDate, String stayCity, String homeCity, String homeDistrict, String homeWard, String homeAddress, int phoneNumber, String email, String[] symptom, String[] exposure) {
        this.name = name;
        this.yearBirth = yearBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.citizenId = citizenId;
        this.travelInformation = travelInformation;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.departureDate = departureDate;
        this.arriveDate = arriveDate;
        this.stayCity = stayCity;
        this.homeCity = homeCity;
        this.homeDistrict = homeDistrict;
        this.homeWard = homeWard;
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.symptom = symptom;
        this.exposure = exposure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(String citizenId) {
        this.citizenId = citizenId;
    }

    public String getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(String travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity;
    }

    public String getHomeCity() {
        return homeCity;
    }

    public void setHomeCity(String homeCity) {
        this.homeCity = homeCity;
    }

    public String getHomeDistrict() {
        return homeDistrict;
    }

    public void setHomeDistrict(String homeDistrict) {
        this.homeDistrict = homeDistrict;
    }

    public String getHomeWard() {
        return homeWard;
    }

    public void setHomeWard(String homeWard) {
        this.homeWard = homeWard;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }

    public String[] getExposure() {
        return exposure;
    }

    public void setExposure(String[] exposure) {
        this.exposure = exposure;
    }
}
