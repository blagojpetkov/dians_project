package com.example.studenthelpermicroservice2.repository;


import com.example.studenthelpermicroservice2.model.Database;
import com.example.studenthelpermicroservice2.model.University;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UniversityRepository {

    public void invalidateUniversities(){
        Database.getInstance().invalidate();
    }

    public static List<University> getAllUniversities() {
        return Database.getInstance().getUniversities();
    }

    public Optional<University> getUniversityById(Long id) {
        return Database.getInstance().getUniversities().stream().filter(x->x.id.equals(id)).findFirst();
    }

    public List<University> getUniversitiesWithKeyword(String keyword) {
        return Database.getInstance().getUniversities().stream().filter(x->x.name.toLowerCase().contains(keyword.toLowerCase())
        || x.type.toLowerCase().contains(keyword.toLowerCase()) || x.city.toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void gradeUniversity(Long id, Integer grade){
        File f = new File("src/main/java/com/example/studenthelpermicroservice2/database/universities.csv");
        File f1 = new File("src/main/java/com/example/studenthelpermicroservice2/database/universities1.csv");
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
                        // if we find the id of the university we want to grade, we calculate the average of the new grade and append it to the university
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
                f1.renameTo(new File("src/main/java/com/example/studenthelpermicroservice2/database/universities.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        invalidateUniversities();
    }

    public void addNewUniversityToList(Long id, double latitude, double longitude, String name, String imageUrl, String type, String city, String address, String description, String professors) {
        File f = new File("src/main/java/com/example/studenthelpermicroservice2/database/universities.csv");
        File f1 = new File("src/main/java/com/example/studenthelpermicroservice2/database/universities1.csv");
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
                //writes the new university to the file
                fileReader.close();
                br.close();
                writer.close();
                if(f.delete())
                    System.out.println("Deleted file successfully");
                else
                    System.out.println("File wasn't deleted");
                f1.renameTo(new File("src/main/java/com/example/studenthelpermicroservice2/database/universities.csv"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        invalidateUniversities();
    }
}
