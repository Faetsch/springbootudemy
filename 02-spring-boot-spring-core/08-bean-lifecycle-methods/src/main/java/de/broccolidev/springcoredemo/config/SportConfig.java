package de.broccolidev.springcoredemo.config;

import de.broccolidev.springcoredemo.common.Coach;
import de.broccolidev.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swimCoach")
    public Coach createSwimCoach() {
        return new SwimCoach();
    }
}
