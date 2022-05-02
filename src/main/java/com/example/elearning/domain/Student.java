package com.example.elearning.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Student extends User {

    @OneToMany
    private Set<LearningPath> enrolledPaths;

    @OneToMany
    private Set<Course> enrolledCourses;
}
