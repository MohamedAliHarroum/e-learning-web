package com.example.elearning.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class LearningPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "learningPath")
    @JsonIgnore
    Set<PathEnrollment> enrollments;

    @ManyToMany
    @JoinTable(
            name = "learning_path_courses",
            joinColumns = @JoinColumn(name = "learning_path_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private Set<Course> courses;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    private Instructor instructor;
}

