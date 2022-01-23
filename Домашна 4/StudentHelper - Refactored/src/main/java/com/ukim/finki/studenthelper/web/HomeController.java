package com.ukim.finki.studenthelper.web;

import com.ukim.finki.studenthelper.model.University;
import com.ukim.finki.studenthelper.repository.UniversityRepository;
import com.ukim.finki.studenthelper.service.UniversityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    public HomeController(UniversityService universityService, UniversityRepository repository) throws FileNotFoundException {
        this.universityService = universityService;
    }

    @GetMapping
    public String getHome(HttpServletRequest request, Model model){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk")) {
            model.addAttribute("bodyContent", "home");
            return "master-template";
        }
        model.addAttribute("bodyContent", "home-en");
        return "master-template-en";
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
        if(request.getSession().getAttribute("uniList")!=null) {
            List<Long> uniList = (List<Long>) request.getSession().getAttribute("uniList");
            if(uniList.contains(id))
            {
                model.addAttribute("graded", true);
            }
            else model.addAttribute("graded", false);
        }
        else {
            model.addAttribute("graded", false);
        }

        if(universityService.getUniversityById(id).isPresent())
        model.addAttribute("university", universityService.getUniversityById(id).get());
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk")) {
            model.addAttribute("bodyContent", "detailed");
            return "master-template";
        }
        model.addAttribute("bodyContent", "detailed-en");
        return "master-template-en";
    }
    @GetMapping("/about")
    public String getAbout(HttpServletRequest request, Model model){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk")) {
            model.addAttribute("bodyContent", "about");
            return "master-template";
        }
        model.addAttribute("bodyContent", "about-en");
        return "master-template-en";
    }

    @GetMapping("/grade/{id}/{grade}")
    public String getUniversityWithId(HttpServletRequest request, @PathVariable Long id, @PathVariable Integer grade){
         universityService.gradeUniversity(id, grade);
         if(request.getSession().getAttribute("uniList")==null) {
             List<Long> uniList = new ArrayList<>();
             uniList.add(id);
             request.getSession().setAttribute("uniList", uniList);
         }
         else{
             List<Long> uniList = (List<Long>) request.getSession().getAttribute("uniList");
             uniList.add(id);
             request.getSession().setAttribute("uniList", uniList);
         }
        return "redirect:/home/"+id;
    }

    @GetMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getNewUniversityPage(HttpServletRequest request){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk"))
            return "new-university";
        else return "new-university-en";
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createNewUniversity(@RequestParam Double latitude,
                                      @RequestParam Double longitude,
                                      @RequestParam String name,
                                      @RequestParam String imageUrl,
                                      @RequestParam String type,
                                      @RequestParam String city,
                                      @RequestParam String address,
                                      @RequestParam String description,
                                      @RequestParam String professors){
        universityService.addNewUniversityToList(latitude, longitude, name, imageUrl, type, city, address, description, professors);
        return "redirect:/home";
    }
}
