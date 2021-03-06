package com.student_example.student_application.dao;

import com.student_example.student_application.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("FakeData")
public class FakeStudentDaoImpl implements StudentDao {
    private static Map<Integer, Student> students = new HashMap<Integer, Student>(){
        {
            put(1, new Student(1, "Said", "Computer Science"));
            put(2, new Student(2, "Alex U", "Finance"));
            put(3, new Student(3, "Anna", "Maths"));
        }
    };

    @Override
    public Collection<Student> getAllStudents()
    {
        return students.values();
    }

    @Override
    public Student getStudentById(int id)
    {
        return this.students.get(id);
    }

    @Override
    public void removeStudentById(int id) { this.students.remove(id); }

    @Override
    public void updateStudentById(Student student){
        Student _student = getStudentById(student.getId());
        _student.setName(student.getName());
        _student.setCourse(student.getCourse());
        students.put(_student.getId(), student);
    }
    @Override
    public  void insertStudentById(Student student)
    {
        students.put(student.getId(), student);
    }
}
