package com.ukim.finki.studenthelper.web;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.service.UniversityService;
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

    @GetMapping("/{id}")
    public ResponseEntity<University> getUniversityWithId(@PathVariable Long id){
        return universityService.getUniversityById(id)
                .map(university -> ResponseEntity.ok().body(university)).orElseGet(()->ResponseEntity.notFound().build());

    }

    @GetMapping("/keyword/{keyword}")
    public List<University> getUniversitiesWithKeyword(@PathVariable String keyword){
        return universityService.getUniversitiesWithKeyword(keyword);
    }
}
