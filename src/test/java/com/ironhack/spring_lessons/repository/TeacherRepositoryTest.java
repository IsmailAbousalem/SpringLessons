package com.ironhack.spring_lessons.repository;

import com.ironhack.spring_lessons.model.Address;
import com.ironhack.spring_lessons.model.Teacher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

    @SpringBootTest
    class TeacherRepositoryTest {
        @Autowired
        TeacherRepository teacherRepository;

        @Autowired
        AddressRepository addressRepository;

        Teacher teacher;

        @BeforeEach
        void setUp() {
            Address address = new Address(4, "Great Avenue", "4C");
            addressRepository.save(address);

            teacher = new Teacher("John Doe", address);
            teacherRepository.save(teacher);
            System.out.println(teacher);
        }

        @AfterEach
        void tearDown() {
            teacherRepository.deleteById(teacher.getId());
            addressRepository.deleteById(4);
        }

        @Test
        public void findAll_teachers_teacherList() {
            List<Teacher> teacherList = teacherRepository.findAll();
            System.out.println(teacherList);
            assertEquals(4, teacherList.size());
        }

        @Test
        public void findById_validId_correctTeacher() {
            Optional<Teacher> teacherOptional = teacherRepository.findById(1);
            assertTrue(teacherOptional.isPresent());
            System.out.println(teacherOptional.get());
            assertEquals("Alberto Garcia", teacherOptional.get().getTeacher());
        }

    @Test
    public void findById_invalidId_teacherNotPresent() {
        Optional<Teacher> teacherOptional = teacherRepository.findById(999);
        assertTrue(teacherOptional.isEmpty());
    }

}