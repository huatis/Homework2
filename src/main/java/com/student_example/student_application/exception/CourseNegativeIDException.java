package com.student_example.student_application.exception;

public class CourseNegativeIDException extends Exception {
    @Override
    public String getMessage() {
        return "The Course ID must be positive";
    }
}
