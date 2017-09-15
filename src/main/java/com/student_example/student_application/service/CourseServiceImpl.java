package com.student_example.student_application.service;

import com.student_example.student_application.dao.CourseDao;
import com.student_example.student_application.entity.Course;
import com.student_example.student_application.exception.CourseNegativeIDException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CourseServiceImpl implements CourseService{
    CourseDao courseDao;

    @Autowired
    public CourseServiceImpl(@Qualifier("MongoDB") CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public Collection<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public Course getCourseById(int id) throws CourseNegativeIDException {
        if(id < 1)
            throw new CourseNegativeIDException();
        return courseDao.getCourseByID(id);
    }

    @Override
    public void removeCourseById(int id) {
        courseDao.removeCourseById(id);
    }

    @Override
    public void updateCourseById(Course course) {
        courseDao.updateCourse(course);
    }

    @Override
    public void insertCourseById(Course course) {
        courseDao.insertCourse(course);
    }
}
