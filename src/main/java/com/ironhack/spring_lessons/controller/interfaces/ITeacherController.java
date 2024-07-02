package com.ironhack.spring_lessons.controller.interfaces;

import com.ironhack.spring_lessons.model.Teacher;

import java.util.List;

public interface ITeacherController{
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(Integer id);
}
