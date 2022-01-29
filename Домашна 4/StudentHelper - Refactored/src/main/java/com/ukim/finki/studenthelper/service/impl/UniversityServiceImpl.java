package com.ukim.finki.studenthelper.service.impl;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.repository.UniversityRepository;
import com.ukim.finki.studenthelper.service.UniversityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository repository;
    private Random random;

    public UniversityServiceImpl(UniversityRepository repository) {
        this.repository = repository;
        this.random = new Random();
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

    @Override
    public void addNewUniversityToList(double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors) {
        name = name.replace("\"", "“");
        imageUrl = imageUrl.replace("\"", "“");
        type = type.replace("\"", "“");
        city = city.replace("\"", "“");
        address = address.replace("\"", "“");
        description = description.replace("\"", "“");
        professors = professors.replace("\"", "“");
        //to protect database from failing if a user enters '"' in the university parameters
        repository.addNewUniversityToList(Math.abs(random.nextLong()/10000), latitude, longitude, name, imageUrl, type, city, address, description, professors);
    }
}
