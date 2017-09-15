package com.student_example.student_application.service;

import com.student_example.student_application.entity.Course;
import com.student_example.student_application.exception.CourseNegativeIDException;

import java.util.Collection;

public interface CourseService {
    Collection<Course> getAllCourses();

    Course getCourseById(int id) throws CourseNegativeIDException;

    void removeCourseById(int id);

    void updateCourseById(Course course);

    void insertCourseById(Course course);
}
