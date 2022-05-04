package com.example.elearning.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@DiscriminatorValue("Student")
@PrimaryKeyJoinColumn(name = "user_id")
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private Set<PathEnrollment> enrolledPaths;

    @OneToMany(mappedBy = "student")
    private Set<CourseEnrollment> enrolledCourses;

    public Student(String username, String email, String password,
                   String firstName, String lastName,
                   String phone, Address address,
                   Set<PathEnrollment> enrolledPaths,
                   Set<CourseEnrollment> enrolledCourses) {
        super(username, email, password, firstName, lastName, phone, address);
        this.enrolledPaths = enrolledPaths;
        this.enrolledCourses = enrolledCourses;
    }
}
