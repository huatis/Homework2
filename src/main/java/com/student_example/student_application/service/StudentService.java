package com.student_example.student_application.service;

import com.student_example.student_application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.student_example.student_application.dao.StudentDao;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier("MySQLData")
    private StudentDao studentDao;
    public Collection<Student> getAllStudents()
    {
        return studentDao.getAllStudents();
    }
    public Student getStudentById(int id)
    {
        return this.studentDao.getStudentById(id);
    }
    public void removeStudentById(int id)
    {
        this.studentDao.removeStudentById(id);
    }
    public void updateStudentById(Student student){ this.studentDao.updateStudentById(student);}
    public void insertStudentById(Student student){ this.studentDao.insertStudentById(student);}
}
