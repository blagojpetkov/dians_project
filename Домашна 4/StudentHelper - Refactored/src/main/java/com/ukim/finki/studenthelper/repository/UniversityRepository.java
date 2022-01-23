package com.ukim.finki.studenthelper.repository;

import com.ukim.finki.studenthelper.model.University;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Repository
public class UniversityRepository {
    public static List<University> universities;



    public void invalidateUniversities(){
        universities = null;
    }

    public static List<University> getAllUniversities() {
        if(universities==null){
        File f = new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv");
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            universities = br.lines().map(x->{
                String [] components = x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                components = Arrays.stream(components).map(string->{
                    if(string.startsWith("\"") && string.endsWith("\""))
                        string = string.substring(1, string.length()-1);
                    return string;
                }).toArray(String[]::new);
                return new University(Long.parseLong(components[0]), Double.parseDouble(components[1]), Double.parseDouble(components[2]), components[3], components[4], components[5], components[6], components[7], components[8], components[9], components[10], components[11]);
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        }

        return universities;
    }

    public Optional<University> getUniversityById(Long id) {
        return UniversityRepository.getAllUniversities().stream().filter(x->x.id.equals(id)).findFirst();
    }

    public List<University> getUniversitiesWithKeyword(String keyword) {
        return UniversityRepository.getAllUniversities().stream().filter(x->x.name.toLowerCase().contains(keyword.toLowerCase())
        || x.type.toLowerCase().contains(keyword.toLowerCase()) || x.city.toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void gradeUniversity(Long id, Integer grade){
        File f = new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv");
        File f1 = new File("src/main/java/com/ukim/finki/studenthelper/database/universities1.csv");
        if(f.exists()) {
            try {
                FileReader fileReader = new FileReader(f);
                BufferedReader br = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(f1);
                String string = null;
                while ((string = br.readLine()) != null) {
                    String [] components = string.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    if(Long.parseLong(components[0])==id) {
                        writer.write(components[0] + "," + components[1] + "," + components[2] + "," + components[3] + "," + components[4] +
                                "," + components[5] + "," + components[6] + "," + components[7] + "," + components[8] +
                                "," + components[9] + "," + String.format("%.2f", ((Double.parseDouble(components[10]) * Integer.parseInt(components[11]) + grade) / (Integer.parseInt(components[11]) + 1))) + "," + (Integer.parseInt(components[11]) + 1) + "\n");
                    }
                    else{
                        writer.write(string+"\n");
                    }
                }
                fileReader.close();
                br.close();
                writer.close();
                if(f.delete())
                    System.out.println("Deleted file successfully");
                else
                    System.out.println("File wasn't deleted");
                f1.renameTo(new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        invalidateUniversities();
    }

    public void addNewUniversityToList(Long id, double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors) {
        File f = new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv");
        File f1 = new File("src/main/java/com/ukim/finki/studenthelper/database/universities1.csv");
        if(f.exists()) {
            try {
                FileReader fileReader = new FileReader(f);
                BufferedReader br = new BufferedReader(fileReader);
                FileWriter writer = new FileWriter(f1);
                String string = null;
                while ((string = br.readLine()) != null) {
                        writer.write(string+"\n");
                }
                writer.write(String.format("%d,%f,%f,%s,%s,%s,%s,\"%s\",\"%s\",\"%s\",0,0\n", id, latitude, longitude, name, imageUrl, type, city, address, description, professors));
                fileReader.close();
                br.close();
                writer.close();
                if(f.delete())
                    System.out.println("Deleted file successfully");
                else
                    System.out.println("File wasn't deleted");
                f1.renameTo(new File("src/main/java/com/ukim/finki/studenthelper/database/universities.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        invalidateUniversities();
    }
}
