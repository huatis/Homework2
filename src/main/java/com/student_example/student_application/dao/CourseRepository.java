package com.student_example.student_application.dao;

import com.student_example.student_application.entity.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    Course getCourseById(int id);
    void deleteCourseById(int id);

    @Query("{id:?0}")
    Course getCourseById2(int id);
}
