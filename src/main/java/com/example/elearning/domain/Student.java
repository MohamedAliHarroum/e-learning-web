package com.example.elearning.domain;

import lombok.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Student extends User {

    @OneToMany(mappedBy = "student")
    private Set<PathEnrollment> enrolledPaths;

    @OneToMany(mappedBy = "student")
    private Set<CourseEnrollment> enrolledCourses;

    public Student(String email, String password,
                   String firstName, String lastName,
                   String phone, Address address,
                   Set<PathEnrollment> enrolledPaths,
                   Set<CourseEnrollment> enrolledCourses) {
        super(email, password, firstName, lastName, phone, address);
        this.enrolledPaths = enrolledPaths;
        this.enrolledCourses = enrolledCourses;
    }
}
