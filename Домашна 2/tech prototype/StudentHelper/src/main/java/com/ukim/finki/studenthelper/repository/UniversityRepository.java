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
                return new University(Long.parseLong(components[0]), Double.parseDouble(components[1]), Double.parseDouble(components[2]), components[3], "university");
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Optional<University> getUniversityById(Long id) {
        return getAllUniversities().stream().filter(x->x.id.equals(id)).findFirst();
    }
}
