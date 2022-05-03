package com.example.elearning.services;

import com.example.elearning.domain.Course;
import com.example.elearning.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
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
}
