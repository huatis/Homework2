package com.student_example.student_application.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @RequestMapping(value={"/greeting", "/"})
    public ModelAndView greeting(Model model) {
        ModelAndView mav = new ModelAndView("Greeting");
        mav.addObject("name", "student");
        return mav;
    }
}
