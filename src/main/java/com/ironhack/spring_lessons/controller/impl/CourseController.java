package com.ironhack.spring_lessons.controller.impl;

import com.ironhack.spring_lessons.controller.dto.CourseClassroomDTO;
import com.ironhack.spring_lessons.controller.dto.CourseHoursDTO;
import com.ironhack.spring_lessons.model.Course;
import com.ironhack.spring_lessons.repository.CourseRepository;
import com.ironhack.spring_lessons.service.interfaces.ICourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    ICourseService courseService;

//    ********************************************* GET *********************************************

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/courses/{course}")
    public Course getCourseById(@PathVariable String course) {
        return courseService.getCourseById(course);
    }

    @GetMapping("/courses/hours")
    public List<Course> getCoursesByHoursLessThan(@RequestParam(defaultValue = "100") Integer hours) {
        return courseService.getCoursesByHoursLessThan(hours);
    }

    @GetMapping("/courses/classroom")
    public List<Course> getCoursesByClassroomAndHours(
            @RequestParam(defaultValue = "A1") String classroom,
            @RequestParam Optional<Integer> hours
    ) {
        return courseService.getCoursesByClassroomAndHours(classroom, hours);
    }


//    ********************************************* POST - CREATING INFO/SAVING *********************************************

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody @Valid Course course) {
        courseService.saveCourse(course);
    }


    //    ********************************************* PUT - UPDATING INFO, BUT NEEDS ALL OF THE INFO *********************************************

    @PutMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCourse(@RequestBody @Valid Course course, @PathVariable String id) {
        courseService.updateCourse(course, id);
    }


    //    ********************************************* PATCH - UPDATING INFO, BUT NEEDS THE SPECIFIC PIECE OF INFO *********************************************

    @PatchMapping("/courses/hours/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatedCourseHours(@RequestBody @Valid CourseHoursDTO courseHoursDTO, @PathVariable String id) {
        courseService.updateCourseHours(courseHoursDTO.getHours(), id);
    }

    @PatchMapping("/courses/classroom/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatedCourseClassroom(@RequestBody @Valid CourseClassroomDTO courseClassroomDTO, @PathVariable String id) {
        courseService.updateCourseClassroom(courseClassroomDTO.getClassroom(), id);
    }


    //    ********************************************* DELETE - DELETE OR REMOVE A RECORD FROM A TABLE *********************************************

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }


}
