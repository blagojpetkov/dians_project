package com.example.studenthelpermicroservice3.web;


import com.example.studenthelpermicroservice3.model.University;
import com.example.studenthelpermicroservice3.repository.UniversityRepository;
import com.example.studenthelpermicroservice3.service.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {
    private final UniversityService universityService;

    public HomeController(UniversityService universityService) throws FileNotFoundException {
        this.universityService = universityService;
    }
    @GetMapping("/grade/{id}/{grade}")
    public String getUniversityWithId(HttpServletRequest request, @PathVariable Long id, @PathVariable Integer grade){
        universityService.gradeUniversity(id, grade);
        return "main";
    }

    @PostMapping("/create")
    public String createNewUniversity(@RequestBody University university){
        universityService.addNewUniversityToList(university.latitude, university.longitude, university.name, university.imageUrl, university.type, university.city, university.address, university.description, university.professors);
        return "main";
    }
}
