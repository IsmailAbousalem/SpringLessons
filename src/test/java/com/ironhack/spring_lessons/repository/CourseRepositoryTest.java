package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Course;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void setUp() {
        Course algebra = new Course("Algebra", 150, "B1", "3 weeks", 3);
        courseRepository.save(algebra);
    }


    @AfterEach
    void tearDown() {
        courseRepository.deleteById("Algebra");
    }


//    JPA TESTS

    @Test
    public void findAll_courses_courseList() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println(courseList);
        assertEquals(7, courseList.size());
    }

    @Test
    public void findById_validId_correctCourse() {
        Optional<Course> courseOptional = courseRepository.findById("Math");
        assertTrue(courseOptional.isPresent());
        System.out.println(courseOptional.get());
        assertEquals(100, courseOptional.get().getHours());
    }

    @Test
    public void findById_invalidId_courseNotPresent() {
        Optional<Course> courseOptional = courseRepository.findById("History");
        assertTrue(courseOptional.isEmpty());
    }

    @Test
    public void findByHours_validHours_correctCourse() {
        Optional<Course> courseOptional = courseRepository.findByHours(50);
        assertTrue(courseOptional.isPresent());
        System.out.println(courseOptional.get());
        assertEquals("English", courseOptional.get().getCourse());
    }

    @Test
    public void findAllByClassroom_validClassroom_courseList() {
        List<Course> courseList = courseRepository.findAllByClassroom("B1");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllByCourseContaining_str_courseList() {
        List<Course> courseList = courseRepository.findAllByCourseContaining("p");
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllByHoursLessThan_validHours_courseList() {
        List<Course> courseList = courseRepository.findAllByHoursLessThan(150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }


//    JPQL TESTS

    @Test
    public void findAllWhereHours150_course_courseList() {
        List<Course> courseList = courseRepository.findAllWhereHours150();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void findAllWhereClassroomAndHoursParams_course_courseList() {
        List<Course> courseList = courseRepository.findAllWhereClassroomAndHoursParams("B1", 150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }


//    NATIVE SQL TESTS

    @Test
    public void nativeFindAllWhereHours150_course_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereHours150();
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }

    @Test
    public void nativeFindAllWhereClassroomAndHoursParams_course_courseList() {
        List<Course> courseList = courseRepository.nativeFindAllWhereClassroomAndHoursParams("B1", 150);
        System.out.println(courseList);
        assertEquals(3, courseList.size());
    }


}
