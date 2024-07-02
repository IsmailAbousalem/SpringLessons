package com.ironhack.spring_lessons.controller.impl;

import com.ironhack.spring_lessons.model.Course;
import com.ironhack.spring_lessons.model.Teacher;
import com.ironhack.spring_lessons.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable String course) {
        Optional<Course> courseOptional = courseRepository.findById(course);
        if (courseOptional.isEmpty()) return null;
        return courseOptional.get();
    }

    @GetMapping("/courses/hours")
    public List<Course> getCoursesByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseRepository.findAllByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCoursesByClassroomAndHours(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours
    ) {
        if (hours.isPresent()) return courseRepository.findAllWhereClassroomAndHoursParams(classroom, hours.get());
        return courseRepository.findAllByClassroom(classroom);
    }
}
