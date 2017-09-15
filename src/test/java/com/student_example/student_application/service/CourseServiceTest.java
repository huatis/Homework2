package com.student_example.student_application.service;

import com.student_example.student_application.dao.CourseDao;
import com.student_example.student_application.entity.Course;
import com.student_example.student_application.exception.CourseNegativeIDException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class CourseServiceTest {

    private Course courseMock;

    private CourseDao courseDaoMock;

    private CourseService courseService;

    private Course course;

    //static fileds
    private static final int VALID_COURSE_ID = 1;
    private static final int INVALID_COURSE_ID = 2;
    private static final int NEGATIV_COURSE_ID = -1;
    private static final String VALID_COURSE_NAME = "Test Course Name";


    @Before
    public void setUp() throws Exception {
        courseMock = Mockito.mock(Course.class);
        courseDaoMock = Mockito.mock(CourseDao.class);
        //MockitoAnnotations.initMocks(this);
        givenACourse();
        givenACourseDao();
        givenACourseService();
    }

    private void givenACourseService() {
        courseService = new CourseServiceImpl(courseDaoMock);
    }

    private void givenACourseDao() {
        when(courseDaoMock.getCourseByID(VALID_COURSE_ID)).thenReturn(courseMock);
    }

    private void givenACourse() {
        when(courseMock.getId()).thenReturn(1);
        when(courseMock.getName()).thenReturn(VALID_COURSE_NAME);
        when(courseMock.getTeacher()).thenReturn("Test Teacher Name");
        when(courseMock.getAppointment()).thenReturn("Friday 10:00 am");
    }

    @Test
    public void testExitentCourse() throws CourseNegativeIDException {
       whenServiceCalledExistentCourse();
       thenCourseNameShouldValid();
    }

    private void thenCourseNameShouldValid() {
        assertEquals(VALID_COURSE_NAME, course.getName());
    }

    private void whenServiceCalledExistentCourse() throws CourseNegativeIDException{
        course = courseService.getCourseById(VALID_COURSE_ID);
    }

    @Test
    public void testNonExistentCourse() throws CourseNegativeIDException {
        whenServiceCallNonExistentCourse(INVALID_COURSE_ID);
        thenCourseNameShouldNull();
    }

    private void thenCourseNameShouldNull() {
        assertNull(course);
    }

    private void whenServiceCallNonExistentCourse(int invalidCourseId) throws CourseNegativeIDException{
        course = courseService.getCourseById(invalidCourseId);
    }

    @Test(expected = CourseNegativeIDException.class)
    public void testCourseWithNegativeID() throws CourseNegativeIDException {
        whenServiceCallwithNegativeIDSouldThrownException();
    }

    private void whenServiceCallwithNegativeIDSouldThrownException() throws CourseNegativeIDException {
        course = courseService.getCourseById(NEGATIV_COURSE_ID);
    }
}
