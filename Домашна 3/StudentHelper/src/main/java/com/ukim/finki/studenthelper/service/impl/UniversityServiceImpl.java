package com.ukim.finki.studenthelper.service.impl;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.repository.UniversityRepository;
import com.ukim.finki.studenthelper.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository repository;

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<University> getUniversityById(Long id) {
        return repository.getUniversityById(id);
    }

    @Override
    public List<University> getAllUniversities() {
        return repository.getAllUniversities();
    }

    @Override
    public List<University> getUniversitiesWithKeyword(String keyword) {
        return repository.getUniversitiesWithKeyword(keyword);
    }

    @Override
    public void gradeUniversity(Long id, Integer grade) {
        repository.gradeUniversity(id, grade);
    }
}
