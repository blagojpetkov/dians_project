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

import javax.servlet.http.HttpServletRequest;
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
    public String getHome(HttpServletRequest request){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk"))
        return "home";
        else return "home-en";
    }

    @GetMapping("/language/{language}")
    public String chooseLanguage(@PathVariable String language, HttpServletRequest request){
        if(language.equals("en"))
            request.getSession().setAttribute("language", "en");
        else request.getSession().setAttribute("language", "mk");
        return "redirect:/home";

    }

    @GetMapping("/{id}")
    public String getUniversity(@PathVariable Long id, Model model, HttpServletRequest request){
        if(universityService.getUniversityById(id).isPresent())
        model.addAttribute("university", universityService.getUniversityById(id).get());
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk"))
        return "detailed";
        else return "detailed-en";
    }
    @GetMapping("/about")
    public String getAbout(HttpServletRequest request){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk"))
        return "about";
        else return "about-en";
    }

}
