package com.student_example.student_application.component;

import com.student_example.student_application.dao.CourseRepository;
import org.springframework.boot.CommandLineRunner;

public class DbSeeder implements CommandLineRunner{
    CourseRepository courses;

    public DbSeeder(CourseRepository courses) {
        this.courses = courses;
    }

    @Override
    public void run(String... strings) throws Exception {
    }
}
