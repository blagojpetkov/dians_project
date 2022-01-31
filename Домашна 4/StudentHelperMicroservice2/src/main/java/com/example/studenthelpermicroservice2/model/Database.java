package com.example.studenthelpermicroservice2.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
    public static Database instance;

    private List<University> universities;
    public List<University> getUniversities() {
        return universities;
    }
    public void setUniversities(List<University> universities) {
        this.universities = universities;
    }

    public static Database getInstance(){
        if(instance==null){
            instance = new Database();

            //initializes the list of universities
            File f = new File("src/main/java/com/example/studenthelpermicroservice2/database/universities.csv");
            try {
                BufferedReader br = new BufferedReader(new FileReader(f));
                instance.universities = br.lines().map(x->{
                    String [] components = x.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                    // splits the components of a single line.
                    // regex to ignore commas in quotes when splitting a comma seperated string
                    // We can't use "," for the regex because we use quotation marks to mark commas ',' in strings that we don't want to affect the csv file.

                    components = Arrays.stream(components).map(string->{
                        if(string.startsWith("\"") && string.endsWith("\""))
                            string = string.substring(1, string.length()-1);
                        return string;
                    }).toArray(String[]::new);
                    //removes the quotation marks

                    return new University(Long.parseLong(components[0]), Double.parseDouble(components[1]), Double.parseDouble(components[2]), components[3], components[4], components[5], components[6], components[7], components[8], components[9], components[10], components[11]);
                }).collect(Collectors.toList());
                //returns a list of the universities
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Database database = new Database();
                database.universities = new ArrayList<>();
                return database;
            }
        }
        return instance;
    }

    public void invalidate(){
        instance = null;
    }

}
