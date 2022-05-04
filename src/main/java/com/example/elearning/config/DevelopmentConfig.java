package com.example.elearning.config;

import com.example.elearning.domain.*;
import com.example.elearning.services.CourseService;
import com.example.elearning.services.EnrollmentService;
import com.example.elearning.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Collections;

@Profile("!production")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner databaseSeeder(UserService userService,
                                            CourseService courseService,
                                            EnrollmentService enrollmentService) {
        return args -> {
            Address address = new Address(
                    "Rue Tunis", "Monastir",
                    "Monastir", "Tunisia", 5000
            );

            Instructor instructor = new Instructor(
                    "dali", "dali@gmail.com", "dali",
                    "Dali", "Harroum", "+21628230381",
                    address, Collections.emptySet(), Collections.emptySet()
            );

            Student student = new Student(
                    "riadh", "riadh@gmail.com", "riadh",
                    "Riadh", "Laabidi", "+21655305173",
                    address, Collections.emptySet(), Collections.emptySet()
            );

            Course course1 = new Course(
                    "Hello World 1",
                    "This a course example for testing",
                    Collections.emptySet(),
                    Collections.emptySet(),
                    instructor
            );
            Course course2 = new Course(
                    "Hello World 2",
                    "This a course example for testing",
                    Collections.emptySet(),
                    Collections.emptySet(),
                    instructor
            );

            CourseEnrollment courseEnrollment1 = new CourseEnrollment();
            courseEnrollment1.setCourse(course1);
            courseEnrollment1.setStudent(student);

            CourseEnrollment courseEnrollment2 = new CourseEnrollment();
            courseEnrollment2.setCourse(course2);
            courseEnrollment2.setStudent(student);

            userService.add(instructor);
            userService.add(student);

            courseService.add(course1);
            courseService.add(course2);

            enrollmentService.add(courseEnrollment1);
            enrollmentService.add(courseEnrollment2);
        };
    }
}
