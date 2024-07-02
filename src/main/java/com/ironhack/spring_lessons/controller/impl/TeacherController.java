package com.ironhack.spring_lessons.controller.impl;

import com.ironhack.spring_lessons.controller.interfaces.ITeacherController;
import com.ironhack.spring_lessons.model.Teacher;
import com.ironhack.spring_lessons.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TeacherController implements ITeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @GetMapping("/teachers/{id}")
    public Teacher getTeacherById(@PathVariable Integer id) {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if (teacherOptional.isEmpty()) return null;
        return teacherOptional.get();
    }

}
