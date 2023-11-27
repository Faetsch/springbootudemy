package de.broccolidev.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class DemoController {
    //create a mapping for /hello
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("theDate", new Date());
        //thymeleaf is configured in pom , so Spring will look for src/main/resources/templates/helloworld-backup.html
        return "helloworld-backup";
    }
}
