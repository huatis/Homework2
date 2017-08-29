package com.student_example.student_application.dao;


import com.student_example.student_application.Mapper.StudentRowMapper;
import com.student_example.student_application.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
@Qualifier("MySQLData")
public class MySQLStudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Collection<Student> getAllStudents() {
        final String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course FROM students WHERE id= ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
        final String sql = "DELETE FROM students where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateStudentById(Student student) {
        final String sql = "UPDATE students set name=?, course=? where id=?";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getCourse(), student.getId()});
    }

    @Override
    public void insertStudentById(Student student) {
        final String sql = "INSERT into students (name, course) values (?, ?)";
        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getCourse()});
    }
}
