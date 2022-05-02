package com.example.elearning.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @NotNull
    private Instructor instructor;

    private Date createdAt;

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
