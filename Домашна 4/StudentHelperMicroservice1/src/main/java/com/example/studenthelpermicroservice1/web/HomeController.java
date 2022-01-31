package com.example.studenthelpermicroservice1.web;


import com.example.studenthelpermicroservice1.model.University;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final RestTemplate template;
    private Random random;

    public HomeController(RestTemplate template) throws FileNotFoundException {
        this.template = template;
        random = new Random();
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
        University university = template.getForObject("http://microservice3/universities/" + id, University.class);
        if(university!=null)
        model.addAttribute("university", university);
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
        try {
            template.getForObject("http://microservice2/home/grade/" + id + "/" + grade, Object.class);
        }
        catch (Exception e){
            System.out.println("Exception happened in microservice 2");
        }
        try {
            template.getForObject("http://microservice3/home/grade/" + id + "/" + grade, Object.class);
        }
        catch (Exception e){
            System.out.println("Exception happened in microservice3");
        }

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
        //uniList is a list containing the universities that the user has already graded.
        //it serves so that he can't grade the same university twice in the same session.

        return "redirect:/home/"+id;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    public String getNewUniversityPage(HttpServletRequest request){
        if(request.getSession().getAttribute("language")==null || request.getSession().getAttribute("language").equals("mk"))
            return "new-university";
        else return "new-university-en";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    public String createNewUniversity(@RequestParam Double latitude,
                                      @RequestParam Double longitude,
                                      @RequestParam String name,
                                      @RequestParam String imageUrl,
                                      @RequestParam String type,
                                      @RequestParam String city,
                                      @RequestParam String address,
                                      @RequestParam String description,
                                      @RequestParam String professors){
        University university = new University(Math.abs(random.nextLong()/10000), latitude, longitude, name, imageUrl, type, city, address, description, professors, "0", "0");
        try {
            template.postForObject("http://microservice2/home/create", university, Object.class);
        }
        catch (Exception e){}
        try {
            template.postForObject("http://microservice3/home/create", university, Object.class);
        }
        catch (Exception e){}
       return "redirect:/home";
    }
}
