package com.student_example.student_application.controller;

import com.student_example.student_application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllCourse(){
        return new ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
    }
}
