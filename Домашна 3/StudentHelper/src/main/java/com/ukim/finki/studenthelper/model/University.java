package com.ukim.finki.studenthelper.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class University {
    public Long id;
    public double latitude;
    public double longitude;
    public String name;
    public String type;
    public String hours;
    public String website;
    public String imageUrl;
    public String location;
    public List<String> professors;


    public University(Long id, double latitude, double longitude, String name, String imageUrl, String type, String location) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
        this.location = location;
    }

    public University(Long id, double latitude, double longitude, String name, String imageUrl, String type, String location, String unparsedProfessors) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
        this.location = location;
        this.professors = Arrays.stream(unparsedProfessors.split("\\.")).collect(Collectors.toList());
    }
}
