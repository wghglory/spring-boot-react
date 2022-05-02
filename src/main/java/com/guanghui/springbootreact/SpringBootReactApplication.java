package com.guanghui.springbootreact;

import com.guanghui.springbootreact.course.Course;
import com.guanghui.springbootreact.course.CourseRepository;
import com.guanghui.springbootreact.domain.Car;
import com.guanghui.springbootreact.domain.CarRepository;
import com.guanghui.springbootreact.domain.Owner;
import com.guanghui.springbootreact.domain.OwnerRepository;
import com.guanghui.springbootreact.stutent.Student;
import com.guanghui.springbootreact.stutent.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class SpringBootReactApplication implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootReactApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = Owner.builder().firstName("Derek").lastName("Wang").build();
        Owner owner2 = Owner.builder().firstName("Iris").lastName("Yuan").build();
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        carRepository.save(Car.builder().owner(owner1).brand("Ford").color("Red").model("Mustang").price(59000).registerNumber("ADF-1121").year(2021).build());
        carRepository.save(Car.builder().owner(owner2).brand("Nissan").color("White").model("Leaf").price(29000).registerNumber("SSJ-3021").year(2019).build());
        carRepository.save(Car.builder().owner(owner1).brand("Toyota").color("Silver").model("Prius").price(39000).registerNumber("KKO-2121").year(2020).build());

        for (Car car : carRepository.findAll()) {
//        TODO:    Owner owner = car.getOwner();
//            Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate com.guanghui.springbootreact.domain.Car.toString()
            logger.info(car.getBrand() + " / " + car.getModel() + " / " + car.getYear());
        }

        Course courseMath = Course.builder().name("Math").credit(6).build();
        Course courseChinese = Course.builder().name("Chinese").credit(3).build();
        courseRepository.saveAll(Arrays.asList(courseMath, courseChinese));

        Student studentQing = Student.builder().firstName("Qing").lastName("Wang").courses(Set.of(courseChinese, courseMath)).build();
        Student studentXiuLan = Student.builder().firstName("XiuLan").lastName("Sui").courses(Set.of(courseMath)).build();
        studentRepository.saveAll(Arrays.asList(studentQing, studentXiuLan));

//        TODO: how to save to course_student table?
    }
}
