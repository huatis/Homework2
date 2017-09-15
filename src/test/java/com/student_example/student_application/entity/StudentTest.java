package com.student_example.student_application.entity;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StudentTest {

    private static final int OLD_ID = 1;
    private static final String OLD_NAME = "Test Name";
    private static final String OLD_COURSE = "Test Course";
    private static final int NEW_ID = 2;
    private static final String NEW_NAME = "NewTestName";
    private static final String NEW_COURSE = "NewTestCourse";

    @Mock
    private Student studentMock;

    @Before
    public void Initialize(){
        MockitoAnnotations.initMocks(this);
        givenAStudent();
    }

    private void givenAStudent() {
        when(studentMock.getId()).thenReturn(OLD_ID, NEW_ID);
        when(studentMock.getName()).thenReturn(OLD_NAME, NEW_NAME);
        when(studentMock.getCourse()).thenReturn(OLD_COURSE, NEW_COURSE);
    }

    @Test
    public void getId() throws Exception {
        assertEquals(1, studentMock.getId());
    }

    @Test
    public void setId() throws Exception {
        assertEquals(OLD_ID, studentMock.getId());
        studentMock.setId(NEW_ID);
        verify(studentMock, times(1)).setId(NEW_ID);
        assertEquals(NEW_ID, studentMock.getId());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Test Name", studentMock.getName());
    }

    @Test
    public void setName() throws Exception {
        assertEquals(OLD_NAME, studentMock.getName());
        studentMock.setName(NEW_NAME);
        verify(studentMock, times(1)).setName(NEW_NAME);
        assertEquals(NEW_NAME, studentMock.getName());
    }

    @Test
    public void getCourse() throws Exception {
        assertEquals("Test Course", studentMock.getCourse());
    }

    @Test
    public void setCourse() throws Exception {
        assertEquals(OLD_COURSE, studentMock.getCourse());
        studentMock.setCourse(NEW_COURSE);
        verify(studentMock, times(1)).setCourse(NEW_COURSE);
        assertEquals("NewTestCourse", studentMock.getCourse());
    }

}