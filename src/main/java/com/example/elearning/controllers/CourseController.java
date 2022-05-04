package com.example.elearning.controllers;

import com.example.elearning.domain.*;

import com.example.elearning.services.CourseService;
import com.example.elearning.services.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    @Autowired
    public CourseController(CourseService courseService,
                            EnrollmentService enrollmentService) {
        this.courseService = courseService;
        this.enrollmentService = enrollmentService;
    }

    @GetMapping("/courses/{id}")
    public Course get(@PathVariable Long id) {
        return courseService.get(id);
    }

    @GetMapping("/courses")
    public Iterable<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping("/courses")
    @ResponseStatus(HttpStatus.CREATED)
    public Course post(@RequestBody Course course) {
        return courseService.add(course);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @PostMapping("/courses/{id}/enroll")
    public void enroll(@PathVariable Long id) {
        courseService.enroll(id);
    }
}
