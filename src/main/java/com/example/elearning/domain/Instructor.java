package com.example.elearning.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
public class Instructor extends User {

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;

    @OneToMany(mappedBy = "instructor")
    private Set<LearningPath> paths;
}
