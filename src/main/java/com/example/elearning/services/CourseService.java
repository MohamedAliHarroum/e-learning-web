package com.example.elearning.services;

import com.example.elearning.domain.Course;
import com.example.elearning.domain.CourseEnrollment;
import com.example.elearning.repositories.CourseRepository;
import com.example.elearning.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository,
                         EnrollmentRepository enrollmentRepository) {
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public Course add(Course course) {
        return courseRepository.save(course);
    }

    public Course get(Long id) {
        return courseRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Iterable<Course> getAll() {
        return courseRepository.findAll();
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public CourseEnrollment enroll(Long id) {
        CourseEnrollment ce = new CourseEnrollment();
        ce.setCourse(get(id));
        return enrollmentRepository.save(ce);
    }
}
