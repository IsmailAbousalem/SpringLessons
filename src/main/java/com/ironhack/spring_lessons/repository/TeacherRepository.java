package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository                             // JpaRepository<Entity, entity primary key data type>
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


}
