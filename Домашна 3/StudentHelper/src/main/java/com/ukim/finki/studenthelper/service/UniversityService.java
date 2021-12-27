package com.ukim.finki.studenthelper.service;

import com.ukim.finki.studenthelper.model.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    Optional<University> getUniversityById(Long id);
    List<University> getAllUniversities();
    List<University> getUniversitiesWithKeyword(String keyword);
    void gradeUniversity(Long id, Integer grade);
}
