package com.student_example.student_application.exception;

public class StudentNegativeIDException extends Exception {
    @Override
    public String getMessage() {
        return "Student ID must be greater than 0";
    }
}
