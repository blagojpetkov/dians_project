package com.ukim.finki.studenthelper.service;

import com.ukim.finki.studenthelper.model.University;

import java.util.List;

public interface UniversityService {
    University getUniversityById(Long id);
    List<University> getAllUniversities();
}
