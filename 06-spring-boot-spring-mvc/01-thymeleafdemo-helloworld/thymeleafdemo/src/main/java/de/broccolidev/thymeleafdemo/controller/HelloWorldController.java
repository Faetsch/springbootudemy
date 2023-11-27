package de.broccolidev.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //new controller method to show initial form
    @GetMapping("/showForm")
    public String showForm(Model model) {
        return "helloworld-form";
    }

    //new controller method to process form
    @RequestMapping("/processForm")
    public String processForm(Model model) {
        return "helloworld";
    }

    //need a controller to make string all caps
//    @RequestMapping("/processFormVersionTwo")
//    public String shout(HttpServletRequest request, Model model) {
//        String studentName = request.getParameter("studentName");
//        studentName = studentName.toUpperCase();
//        final String result = "YO " + studentName;
//        model.addAttribute("allCapsName", result);
//        return "helloworld";
// }

    @PostMapping("/processFormVersionTwo")
    public String shout(@RequestParam("studentName") String studentName, Model model) {
        studentName = studentName.toUpperCase();
        final String result = "YO " + studentName;
        model.addAttribute("allCapsName", result);
        return "helloworld";
    }
}
