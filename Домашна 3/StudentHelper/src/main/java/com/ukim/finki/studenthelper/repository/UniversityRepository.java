package com.ukim.finki.studenthelper.repository;

import com.ukim.finki.studenthelper.model.University;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UniversityRepository {
    public List<University> getAllUniversities() {
        File f = new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            return br.lines().map(x->{
                String [] components = x.split(",");
                return new University(Long.parseLong(components[0]), Double.parseDouble(components[1]), Double.parseDouble(components[2]), components[3], components[4], components[5], components[6], components[7]);
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<University> getUniversityById(Long id) {
        return getAllUniversities().stream().filter(x->x.id.equals(id)).findFirst();
    }

    public List<University> getUniversitiesWithKeyword(String keyword) {
        return getAllUniversities().stream().filter(x->x.name.toLowerCase().contains(keyword.toLowerCase())
        || x.type.toLowerCase().contains(keyword.toLowerCase()) || x.location.toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
