package com.example.elearning.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CourseEnrollment extends Enrollment {

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
