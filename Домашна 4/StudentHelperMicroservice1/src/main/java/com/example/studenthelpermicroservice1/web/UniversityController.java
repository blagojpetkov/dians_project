package com.example.studenthelpermicroservice1.web;


import com.example.studenthelpermicroservice1.model.University;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {
    private final RestTemplate template;

    public UniversityController(RestTemplate restTemplate) {
        this.template = restTemplate;
    }

    @GetMapping("/all")
    public List<University> getAllUniversities(){
        ResponseEntity<University[]> response = template.getForEntity("http://microservice2/universities/all", University[].class);
        List<University> universityList = new ArrayList<>();
        if(response.getBody()!=null)
        Collections.addAll(universityList, response.getBody());
        return universityList;
    }


    @GetMapping("/keyword/{keyword}")
    public List<University> getUniversitiesWithKeyword(@PathVariable String keyword){
        ResponseEntity<University[]> response = template.getForEntity("http://microservice3/universities/keyword/" + keyword, University[].class);
        List<University> universityList = new ArrayList<>();
        if(response.getBody()!=null)
            Collections.addAll(universityList, response.getBody());
        return universityList;
    }
}
