package com.student_example.student_application.controller;

import com.student_example.student_application.entity.Student;
import com.student_example.student_application.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentsUIController {
    @Autowired
    StudentService studentService;

    @RequestMapping("/students")
    public ModelAndView getAllStudents(Model model) {
        ModelAndView mav = new ModelAndView("Students");
        mav.addObject("students", studentService.getAllStudents());
        return mav;
    }
    @RequestMapping(value = "/student")
    public ModelAndView getOneStudent(Model model, @RequestParam(value = "id") int id) {
        ModelAndView mav = new ModelAndView("StudentDetails");
        mav.addObject("student", studentService.getStudentById(id));
        return mav;
    }
    @RequestMapping(value = "/deletestudent")
    public ModelAndView deleteOneStudent(Model model, @RequestParam(value = "id") int id) {
        studentService.removeStudentById(id);
        ModelAndView mav = new ModelAndView("Students");
        mav.addObject("students", studentService.getAllStudents());
        return mav;
    }
    @RequestMapping(value = "/insertstudent")
    public ModelAndView insertOneStudent() {
        ModelAndView mav = new ModelAndView("InsertStudent");
        return mav;
    }
}
