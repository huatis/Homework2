package com.student_example.student_application.dao;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.student_example.student_application.entity.Course;
import com.student_example.student_application.entity.Student;
import org.bson.Document;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import static org.springframework.data.mongodb.core.query.Query.*;

@Repository
@Qualifier("MongoDB")
public class MongoDbCourseImpl implements CourseDao{

    CourseRepository courses;

    public MongoDbCourseImpl(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public Collection<Course> getAllCourses()
    {
        Collection<Course> myList = courses.findAll();//(new Sort.Order(Sort.Direction.ASC, "id"));
        myList.stream().sorted(Comparator.comparing(Course::getId));
        return myList;

    }

    @Override
    public Course getCourseByID(int id) {
        return this.courses.getCourseById2(id);
    }

    @Override
    public void removeCourseById(int id) {
        this.courses.deleteCourseById(id);
    }

    @Override
    public void insertCourse(Course course) {
        this.courses.insert(course);
    }

    @Override
    public void updateCourse(Course course) {
        this.courses.save(course);
    }
}
