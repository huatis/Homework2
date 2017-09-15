package com.student_example.student_application.service;

import com.student_example.student_application.dao.StudentDao;
import com.student_example.student_application.entity.Student;
import com.student_example.student_application.exception.StudentNegativeIDException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentServiceTest {

    @Mock
    private StudentDao studentDao;

    @Mock
    private Student studentMock;

    MockMvc mockMvc;

    private StudentService studentService;
    private Student student;
    private static final int EXIST_STUDENT_ID = 1;
    private static final int NON_EXIST_STUDENT_ID = 2;
    private static final String VALID_STUDENT_NAME = "Test Name";
    private static final int NEGATIVE_STUDENT_ID = -1;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        givenAStudent();
        givenAStudentDao();
        givenAStudentService();
    }

    private void givenAStudentDao() {
        when(studentDao.getStudentById(1)).thenReturn(studentMock);
    }

    private void givenAStudent() {
        when(studentMock.getName()).thenReturn(VALID_STUDENT_NAME);
        when(studentMock.getId()).thenReturn(1);
    }

    private void givenAStudentService() {
        studentService = new StudentService(studentDao);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void getAllStudents() {
    }

    @Test
    public void testGetExistentStudent() throws StudentNegativeIDException {
        givenAStudentDao();
        whenServiceCalledExistentStudent();
        thenStudentNameShouldBeValid();
    }

    @Test(expected = StudentNegativeIDException.class)
    public void testGetStudentWithNegativeID() throws StudentNegativeIDException {
        givenAStudentDao();
        whenServiceCalledStudentWithNegativeIDthenStudentExceptionShouldBeThrown();
    }

    @Test
    public void testGetNonExistentStudent() throws StudentNegativeIDException {
        whenServiceCalledNonExistentStudent();
        thenNoStudentShouldReturn();
    }

    private void thenNoStudentShouldReturn() {
        assertNull(student);
    }

    private void thenStudentNameShouldBeValid() {
        assertEquals(VALID_STUDENT_NAME, student.getName());
    }

    private void whenServiceCalledExistentStudent() throws StudentNegativeIDException {
        student = studentService.getStudentById(EXIST_STUDENT_ID);
    }

    private void whenServiceCalledNonExistentStudent() throws StudentNegativeIDException {
        student = studentService.getStudentById(NON_EXIST_STUDENT_ID);
    }

    private void whenServiceCalledStudentWithNegativeIDthenStudentExceptionShouldBeThrown() throws StudentNegativeIDException {
        student = studentService.getStudentById(NEGATIVE_STUDENT_ID);
    }

    @Test
    public void removeStudentById() {
    }

    @Test
    public void updateStudentById() {
    }

    @Test
    public void insertStudentById() {

    }

}