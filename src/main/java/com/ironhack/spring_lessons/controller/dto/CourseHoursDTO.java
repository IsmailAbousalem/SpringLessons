package com.ironhack.spring_lessons.controller.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class CourseHoursDTO {
    @Max(value = 400, message = "The course cannot be longer than 400 hours")
    @Min(30)
    private Integer hours;

    public CourseHoursDTO() {
    }

    public CourseHoursDTO(Integer hours) {
        this.hours = hours;
    }

    public Integer getHours() {
        return hours;
    }
}
