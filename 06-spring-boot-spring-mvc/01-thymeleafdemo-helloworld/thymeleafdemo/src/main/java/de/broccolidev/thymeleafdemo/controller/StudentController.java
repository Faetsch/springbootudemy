package de.broccolidev.thymeleafdemo.controller;

import de.broccolidev.thymeleafdemo.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${programmingLanguages}")
    private List<String> programmingLanguages;

    @Value("${operatingSystems}")
    private List<String> operatingSystems;

    Logger LOGGER = LoggerFactory.getLogger(getClass().getName());

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        //create a new Student object
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("programmingLanguages", programmingLanguages);
        theModel.addAttribute("operatingSystems", operatingSystems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student theStudent) {
        //log the input data
        LOGGER.debug(theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }

}
