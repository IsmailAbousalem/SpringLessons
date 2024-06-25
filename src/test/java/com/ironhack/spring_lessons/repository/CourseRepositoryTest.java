package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(6, courseList.size());
    }

    @Test
    public void findById_validId_correctCourse() {
        Optional<Course> courseOptional = courseRepository.findById("Math");
        assertTrue(courseOptional.isPresent());
        System.out.println(courseOptional.get());
        assertEquals(100, courseOptional.get().getHours());
    }

    @Test
    public void findbyId_invalidId_courseNotPresent() {
        Optional<Course> courseOptional = courseRepository.findById("History");
        assertTrue(courseOptional.isEmpty());
    }

}
