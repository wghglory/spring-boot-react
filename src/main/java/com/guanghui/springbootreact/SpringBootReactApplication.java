package com.guanghui.springbootreact;

//import com.guanghui.springbootreact.entity.Car;
//import com.guanghui.springbootreact.entity.Course;
//import com.guanghui.springbootreact.entity.Owner;
//import com.guanghui.springbootreact.entity.Student;

import com.guanghui.springbootreact.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.util.Arrays;
//import java.util.Set;

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

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /* mock generate 2 test users in db
        // password generator: http://www.alekssoft.net/hash-generators/bcrypt
        $2a represents the algorithm version and $10 represents the strength of the algorithm.
        The default strength of Spring Security's BcryptPasswordEncoder class is 10.
        BCrypt generates a random salt in hashing, therefore the hashed result is always different.

        // password: ca$hc0w
        User user1 = User.builder().username("derekw").password("$2y$10$aV1hn/tML9Et6EwEjMIC5OYMobdE48LSd1YuscPwvMwUIfTo75fQq").role("ADMIN").build();
        // password: what?
        User user2 = User.builder().username("irisy").password("$2y$10$iwBVpCitr9d71j3bBbpUgO260sCJ4hnP1YRaN/gcm6Imc0Vcs5Pby").role("USER").build();
        // 3 users: guanghuiw 123123, derekw ca$hc0w, irisy what?

        userRepository.save(user1);
        userRepository.save(user2);
        */

//        Owner owner1 = Owner.builder().firstName("Derek").lastName("Wang").build();
//        Owner owner2 = Owner.builder().firstName("Iris").lastName("Yuan").build();
//        ownerRepository.saveAll(Arrays.asList(owner1, owner2));
//
//        carRepository.save(Car.builder().owner(owner1).brand("Ford").color("Red").model("Mustang").price(59000).registerNumber("ADF-1121").year(2021).build());
//        carRepository.save(Car.builder().owner(owner2).brand("Nissan").color("White").model("Leaf").price(29000).registerNumber("SSJ-3021").year(2019).build());
//        carRepository.save(Car.builder().owner(owner1).brand("Toyota").color("Silver").model("Prius").price(39000).registerNumber("KKO-2121").year(2020).build());
//
//        for (Car car : carRepository.findAll()) {
////        TODO:    Owner owner = car.getOwner();
////            Method threw 'org.hibernate.LazyInitializationException' exception. Cannot evaluate com.guanghui.springbootreact.entity.Car.toString()
//            logger.info(car.getBrand() + " / " + car.getModel() + " / " + car.getYear());
//        }
//
//        Course courseMath = Course.builder().name("Math").credit(6).build();
//        Course courseChinese = Course.builder().name("Chinese").credit(3).build();
//        courseRepository.saveAll(Arrays.asList(courseMath, courseChinese));
//
//        Student studentQing = Student.builder().firstName("Qing").lastName("Wang").courses(Set.of(courseChinese, courseMath)).build();
//        Student studentXiuLan = Student.builder().firstName("XiuLan").lastName("Sui").courses(Set.of(courseMath)).build();
//        studentRepository.saveAll(Arrays.asList(studentQing, studentXiuLan));
//
////        TODO: how to save to course_student table?
    }
}
