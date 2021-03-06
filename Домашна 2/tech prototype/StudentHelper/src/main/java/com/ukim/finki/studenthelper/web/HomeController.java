package com.ukim.finki.studenthelper.web;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.repository.UniversityRepository;
import com.ukim.finki.studenthelper.service.UniversityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final UniversityService universityService;

    public HomeController(UniversityService universityService, UniversityRepository repository) throws FileNotFoundException {
        this.universityService = universityService;
    }

    @GetMapping
    public String getHome(){
        return "home";
    }

    @GetMapping("/{id}")
    public String getUniversity(@PathVariable Long id, Model model){
        if(universityService.getUniversityById(id).isPresent())
        model.addAttribute("university", universityService.getUniversityById(id).get());
        return "detailed";
    }
    @GetMapping("/about")
    public String getAbout(){
        return "about";
    }

}
