package com.ironhack.spring_lessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

//    Empty constructor is absolutely necessary for Spring to work properly
    public Teacher() {
    }

//    NOT NECESSARY. EMPTY CONSTRUCTOR IS NECESSARY
    public Teacher(String name) {
        this.name = name;
    }

//    GETTERS AND SETTERS ARE NECESSARY FOR SPRING TO WORK PROPERLY
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    NOT NECESSARY AGAIN
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
