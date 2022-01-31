package com.example.studenthelpermicroservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentHelperMicroservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(StudentHelperMicroservice2Application.class, args);
    }

}
