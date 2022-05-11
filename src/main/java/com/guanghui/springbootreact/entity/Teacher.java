package com.guanghui.springbootreact.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;

    private String firstName;
    private String lastName;

    /*
     Many to One is recommended, so below moved to Course Class.
     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
 //    this will add teacher_id as foreign key in courses table
    private List<Course> courses;
    */
}
