package com.example.elearning.services;

import com.example.elearning.domain.Course;
import com.example.elearning.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private CourseRepository courses;

    @Autowired
    public CourseService(CourseRepository courses) {
        this.courses = courses;
    }

    public Course add(Course course) {
        return courses.save(course);
    }

    public Course get(Long id) {
        return courses
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Iterable<Course> getAll() {
        return courses.findAll();
    }

    public void delete(Long id) {
        courses.deleteById(id);
    }

    public Course update(Course course) {
        return courses.save(course);
    }
}
