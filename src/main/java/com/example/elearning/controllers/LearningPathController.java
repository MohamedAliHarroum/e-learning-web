package com.example.elearning.controllers;

import com.example.elearning.domain.LearningPath;
import com.example.elearning.services.LearningPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class LearningPathController {

    private final LearningPathService learningPathService;

    @Autowired
    public LearningPathController(LearningPathService learningPathService) {
        this.learningPathService = learningPathService;
    }

    @PostMapping("/paths")
    public LearningPath add(@RequestBody LearningPath learningPath) {
        return learningPathService.add(learningPath);
    }

    @GetMapping("/paths/{id}")
    public LearningPath get(@PathVariable Long id) {
        return learningPathService.get(id);
    }

    @GetMapping("/paths")
    public Iterable<LearningPath> getAll() {
        return learningPathService.getAll();
    }

    @DeleteMapping("/paths/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        learningPathService.delete(id);
    }
}
