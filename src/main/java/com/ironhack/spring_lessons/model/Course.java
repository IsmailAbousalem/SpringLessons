package com.ironhack.spring_lessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    private String course;
    private Integer hours;
    private String classroom;
    private String vacations;

    @ManyToOne
    private Teacher teacher;
}
