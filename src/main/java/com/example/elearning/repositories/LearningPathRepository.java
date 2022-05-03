package com.example.elearning.repositories;

import com.example.elearning.domain.LearningPath;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningPathRepository extends CrudRepository<LearningPath, Long> {

}
