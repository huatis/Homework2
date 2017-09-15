package com.student_example.student_application.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    private int id;
    private String name;
    private String teacher;
    private String appointment;

    public Course(int id, String name, String teacher, String appointment) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.appointment = appointment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
}
