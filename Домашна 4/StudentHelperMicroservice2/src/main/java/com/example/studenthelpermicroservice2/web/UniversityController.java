package com.example.studenthelpermicroservice2.web;


import com.example.studenthelpermicroservice2.model.University;
import com.example.studenthelpermicroservice2.service.UniversityService;
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

    @GetMapping("/all")
    public List<University> getAllUniversities(){
        return universityService.getAllUniversities();
    }

}
