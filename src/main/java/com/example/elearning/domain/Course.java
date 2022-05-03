package com.example.elearning.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=8, message = "Title must be at least 8 characters long")
    private String title;

    @Size(min=24, message = "Description must be at least 24 characters long")
    private String description;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @JsonIgnore
    private Instructor instructor;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<CourseEnrollment> enrollments;

    @ManyToMany
    @JsonIgnore
    private Set<LearningPath> learningPaths;

    @CreatedDate
    private Date createdAt;

}
