package com.example.elearning.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Data
public class LearningPath {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "learningPath")
    Set<PathEnrollment> enrollments;

    @ManyToMany
    @JoinTable(
            name = "learning_path_courses",
            joinColumns = @JoinColumn(name = "learning_path_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
}

