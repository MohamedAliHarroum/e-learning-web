package com.example.elearning.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=8, message = "Title must be at least 8 characters long")
    private String title;

    @NotNull
    @Size(min=24, message = "Description must be at least 24 characters long")
    private String description;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @NotNull
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    Set<CourseEnrollment> enrollments;

    @ManyToMany
    private Set<LearningPath> learningPaths;

    @CreatedDate
    private Date createdAt;
}
