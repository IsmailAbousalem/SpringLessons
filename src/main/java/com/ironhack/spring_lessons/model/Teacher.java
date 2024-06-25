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
    private String teacher;

//    Empty constructor is absolutely necessary for Spring to work properly
    public Teacher() {
    }

//    NOT NECESSARY. EMPTY CONSTRUCTOR IS NECESSARY
    public Teacher(String teacher) {
        this.teacher = teacher;
    }

//    GETTERS AND SETTERS ARE NECESSARY FOR SPRING TO WORK PROPERLY
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String name) {
        this.teacher = name;
    }

//    NOT NECESSARY AGAIN
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + teacher + '\'' +
                '}';
    }
}
