package com.student_example.student_application.controller;

import com.student_example.student_application.entity.Student;
import com.student_example.student_application.service.StudentService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    private int id;

    @Test
    public void getStudentById() throws Exception {
        id = 1;
        Student mockStudent = new Student();
        mockStudent.setName("Test Name");
        mockStudent.setCourse("Test Course");
        mockStudent.setId(id);
        //given(studentService.getStudentById(id)).willReturn(mockStudent);
        when(studentService.getStudentById(id)).thenReturn(mockStudent);
        System.out.println("Hello");
        this.mockMvc.perform(get("/api/students/1")).andExpect(status().isOk()).andExpect(content().string(containsString("Test Name")));

    }
}
