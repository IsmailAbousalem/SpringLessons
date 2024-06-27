package com.ironhack.spring_lessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private Integer id;
    private String street;
    private String houseCode;

//    Use only if we want a bidirectional relationship
//    If used, we must be careful not to create a stackOverflow Error (infinite loop)
//    @OneToOne(mappedBy = "address")
//    private Teacher teacher;

    public Address() {
    }

    public Address(Integer id, String street, String houseCode) {
        this.id = id;
        this.street = street;
        this.houseCode = houseCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseCode() {
        return houseCode;
    }

    public void setHouseCode(String houseCode) {
        this.houseCode = houseCode;
    }

//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", houseCode='" + houseCode + '\'' +
                '}';
    }
}
