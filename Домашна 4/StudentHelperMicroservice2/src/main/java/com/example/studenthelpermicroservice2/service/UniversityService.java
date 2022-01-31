package com.example.studenthelpermicroservice2.service;


import com.example.studenthelpermicroservice2.model.University;

import java.util.List;
import java.util.Optional;

public interface UniversityService {
    Optional<University> getUniversityById(Long id);
    List<University> getAllUniversities();
    List<University> getUniversitiesWithKeyword(String keyword);
    void gradeUniversity(Long id, Integer grade);
    void addNewUniversityToList(double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors);
}
