package com.student_example.student_application.entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {
    Student student;

    @Before
    public void Initialize(){
        student = new Student(1,"TestName", "TestCourse");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, student.getId());
    }

    @Test
    public void setId() throws Exception {
        student.setId(2);
        assertEquals(2, student.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("TestName", student.getName());
    }

    @Test
    public void setName() throws Exception {
        student.setName("NewTestName");
        assertEquals("NewTestName", student.getName());
    }

    @Test
    public void getCourse() throws Exception {
        assertEquals("TestCourse", student.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        student.setCourse("NewTestCourse");
        assertEquals("NewTestCourse", student.getCourse());
    }

}