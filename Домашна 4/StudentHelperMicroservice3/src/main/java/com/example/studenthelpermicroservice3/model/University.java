package com.example.studenthelpermicroservice3.model;


public class University {
    public Long id;
    public double latitude;
    public double longitude;
    public String name;
    public String imageUrl;
    public String type;
    public String city;
    public String address;
    public String description;
    public String professors;
    public double grade;
    public int evaluators;

    public University(Long id, double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors, String grade, String evaluators) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.imageUrl = imageUrl;
        this.type = type;
        this.city = city;
        this.address = address;
        this.description = description;
        this.professors = professors;
        this.grade = Double.parseDouble(grade);
        this.evaluators = Integer.parseInt(evaluators);
    }
}
