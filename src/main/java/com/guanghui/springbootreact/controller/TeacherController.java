package com.guanghui.springbootreact.controller;

import com.guanghui.springbootreact.entity.Course;
import com.guanghui.springbootreact.entity.Teacher;
import com.guanghui.springbootreact.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        Course courseDBA = Course.builder().name("DBA").credit(4).build();
        Course courseJAVA = Course.builder().name("JAVA").credit(6).build();

//        teacher.setCourses(List.of(courseDBA, courseJAVA));

        return teacherRepository.save(teacher);
    }
}
