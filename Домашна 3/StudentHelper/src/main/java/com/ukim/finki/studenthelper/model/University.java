package com.ukim.finki.studenthelper.model;


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

    public University(Long id, double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors) {
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
    }
}
