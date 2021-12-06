package com.ukim.finki.studenthelper.model;

public class University {
    public Long id;
    public double latitude;
    public double longitude;
    public String name;
    public String type;
    public String hours;

    public University(Long id, double latitude, double longitude, String name, String type) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.type = type;
    }
}
