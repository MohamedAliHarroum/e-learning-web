package com.example.elearning.services;

import com.example.elearning.domain.Enrollment;
import com.example.elearning.repositories.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment add(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void delete(Long id) {
        enrollmentRepository.deleteById(id);
    }

    public Enrollment get(Long id) {
        return enrollmentRepository
                .findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Iterable<Enrollment> getAll() {
        return enrollmentRepository.findAll();
    }
}
