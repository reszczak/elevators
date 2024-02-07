package com.example.elevatorsapp.config;

import com.example.elevatorsapp.model.ElevatorSystem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElevatorConfig {

    @Bean
    public ElevatorSystem elevatorSystem() {
        return new ElevatorSystem();
    }
}