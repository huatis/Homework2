package com.student_example.student_application.controller;

import com.student_example.student_application.entity.Course;
import com.student_example.student_application.exception.CourseNegativeIDException;
import com.student_example.student_application.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllCourse(){
        return new ResponseEntity(courseService.getAllCourses(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insertCourseById(@RequestBody Course course)
    {
        this.courseService.insertCourseById(course);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourseById(@PathVariable("id") int id){
        courseService.removeCourseById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Course getCourseById(@PathVariable("id") int id) throws CourseNegativeIDException {
        return courseService.getCourseById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCourseById(@RequestBody Course course) {
        courseService.updateCourseById(course);
        return new ResponseEntity(HttpStatus.OK);
    }
}
