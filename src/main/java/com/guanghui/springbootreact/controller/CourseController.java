package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.entity.Course;
import com.guanghui.springbootreact.entity.Teacher;
import com.guanghui.springbootreact.model.CoursePayload;
import com.guanghui.springbootreact.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;

    @PostMapping
    public Course createCourseWithTeacher(@RequestBody CoursePayload coursePayload) {
        String name = coursePayload.getName();
        Integer credit = coursePayload.getCredit();

        Teacher teacher = Teacher.builder().firstName("William").lastName("Zhou").build();
        Course course = Course.builder().name(name).credit(credit).teacher(teacher).build();

        return courseRepository.save(course);
    }

    @GetMapping()
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
