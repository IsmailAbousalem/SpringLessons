package com.ironhack.spring_lessons.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String teacher;

    @OneToOne
    private Address address;

//    Use only if we want a bidirectional relationship
//    If used, we must be careful not to create a stackOverflow Error (infinite loop)
//    @OneToMany(mappedBy = "teacher")
//    List<Course> courses;

    public Teacher() {
    }

//    NOT NECESSARY. EMPTY CONSTRUCTOR IS NECESSARY
    public Teacher(String teacher) {
        this.teacher = teacher;
    }

    public Teacher(String teacher, Address address) {
        this.teacher = teacher;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Course> getCourses() {
//        return courses;
//    }
//
//    public void setCourses(List<Course> courses) {
//        this.courses = courses;
//    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", address=" + address +
                '}';
    }
}
