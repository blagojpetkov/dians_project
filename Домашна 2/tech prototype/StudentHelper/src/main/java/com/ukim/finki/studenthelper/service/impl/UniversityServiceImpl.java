package com.ukim.finki.studenthelper.service.impl;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.repository.UniversityRepository;
import com.ukim.finki.studenthelper.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository repository;

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }

    @Override
    public University getUniversityById(Long id) {
        return repository.getUniversityById(id).orElse(null);
    }

    @Override
    public List<University> getAllUniversities() {
        return repository.getAllUniversities();
    }
}
