package com.student_example.student_application.dao;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.student_example.student_application.entity.Course;
import com.student_example.student_application.entity.Student;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("MongoDB")
public class MongoDbCourseImpl implements CourseDao{

    @Override
    public Collection<Course> getAllCourses() {
        MongoCredential credential = MongoCredential.createCredential("user", "db", "Anna2012".toCharArray());
        MongoClient mongo =  new MongoClient(new ServerAddress("localhost", 27017), Arrays.asList(credential));
        MongoDatabase db = mongo.getDatabase("db");
        MongoCollection<Document> studentsCollection = db.getCollection("students");
        FindIterable<Document> fi = studentsCollection.find();
        MongoCursor cursor = fi.iterator();
        List<Student> studentList = new ArrayList<>();
        while(cursor.hasNext())
        {
            studentList.add((Student)cursor.next());
        }
        return null;
    }

    @Override
    public Course getCourseByID(int id) {
        return null;
    }

    @Override
    public void removeCourseById(int id) {

    }

    @Override
    public void insertCourse(Course course) {

    }

    @Override
    public void updateCourse(Course course) {

    }
}
