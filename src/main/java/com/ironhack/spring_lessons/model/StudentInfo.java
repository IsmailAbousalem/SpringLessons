package com.ironhack.spring_lessons.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentInfo {
    private String street;
    private Integer houseNumber;
    private String phone;

    public StudentInfo(String street, Integer houseNumber, String phone) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
