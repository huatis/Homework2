package com.student_example.student_application.dao;

import com.student_example.student_application.entity.Course;

import java.util.Collection;

public interface CourseDao {
    Collection<Course> getAllCourses();
    Course getCourseByID(int id);
    void removeCourseById(int id);
    void insertCourse(Course course);
    void updateCourse(Course course);
}
