package com.ukim.finki.studenthelper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class StudentHelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentHelperApplication.class, args);
    }

}
