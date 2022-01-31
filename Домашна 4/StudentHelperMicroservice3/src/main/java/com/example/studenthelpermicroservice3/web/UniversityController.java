package com.example.studenthelpermicroservice3.web;


import com.example.studenthelpermicroservice3.model.University;
import com.example.studenthelpermicroservice3.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final UniversityService universityService;

    public UniversityController(UniversityService universityService) {
        this.universityService = universityService;
    }

    @GetMapping("/keyword/{keyword}")
    public List<University> getUniversitiesWithKeyword(@PathVariable String keyword){
        return universityService.getUniversitiesWithKeyword(keyword);
    }

    @GetMapping("/{id}")
    public University getUniversityById(@PathVariable Long id){
        return universityService.getUniversityById(id).orElse(null);
    }
}
