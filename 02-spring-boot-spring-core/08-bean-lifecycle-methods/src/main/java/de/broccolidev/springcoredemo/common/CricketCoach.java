package de.broccolidev.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Play Cricket for 5 hours :)";
    }

    @PostConstruct
    public void doStartupStuff() {
        System.out.println("In doStartupStuff: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doCleanupStuff() {
        System.out.println("In doCleanupStuff " + getClass().getSimpleName());
    }

}
