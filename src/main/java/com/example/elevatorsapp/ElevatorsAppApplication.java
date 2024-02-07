package com.example.elevatorsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ElevatorsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElevatorsAppApplication.class, args);
    }
}
