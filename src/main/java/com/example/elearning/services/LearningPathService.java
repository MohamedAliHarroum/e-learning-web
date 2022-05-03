package com.example.elearning.services;

import com.example.elearning.domain.Course;
import com.example.elearning.domain.LearningPath;
import com.example.elearning.repositories.LearningPathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearningPathService {
    private final LearningPathRepository learningPathRepository;

    @Autowired
    public LearningPathService(LearningPathRepository learningPathRepository) {
        this.learningPathRepository = learningPathRepository;
    }

    public LearningPath add(LearningPath learningPath) {
        return learningPathRepository.save(learningPath);
    }

    public LearningPath get(Long id) {
        return learningPathRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Iterable<LearningPath> getAll() {
        return learningPathRepository.findAll();
    }

    public void delete(Long id) {
        learningPathRepository.deleteById(id);
    }

    public LearningPath update(LearningPath course) {
        return learningPathRepository.save(course);
    }
}
