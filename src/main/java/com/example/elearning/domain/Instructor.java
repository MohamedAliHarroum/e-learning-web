package com.example.elearning.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Instructor extends User {

    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses;

    @OneToMany(mappedBy = "instructor")
    private Set<LearningPath> paths;

    public Instructor(String email, String password,
                      String firstName, String lastName,
                      String phone, Address address,
                      Set<Course> courses,
                      Set<LearningPath> paths) {
        super(email, password, firstName, lastName, phone, address);
        this.courses = courses;
        this.paths = paths;
    }
}
