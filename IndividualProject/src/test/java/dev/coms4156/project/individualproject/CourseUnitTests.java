package dev.coms4156.project.individualproject;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeEach
  public void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }


  @Test
  public void toStringTest() {
    System.out.println("1");
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void isCourseFullTest() {
    System.out.println("2");
    assert(!testCourse.isCourseFull());

    testCourse.setEnrolledStudentCount(125);
    assert(testCourse.isCourseFull());

  }

  @Test
  public void enrollStudentTest() {
    System.out.println("3");
    assert(!testCourse.enrollStudent());

    testCourse.setEnrolledStudentCount(125);
    assert(testCourse.enrollStudent());
  }

  @Test
  public void dropStudentTest() {
    System.out.println("4");
    assert(testCourse.dropStudent());

    testCourse.setEnrolledStudentCount(0);
    assert(!testCourse.dropStudent());
  }

  @Test
  public void getCourseLocationTest() {
    System.out.println("5");
    String expected = "417 IAB";
    assertEquals(expected, testCourse.getCourseLocation());

    String newExpected = "309 HAV";
    testCourse.reassignLocation(newExpected);
    assertEquals(newExpected, testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    System.out.println("6");
    String expected = "Griffin Newbold";
    assertEquals(expected, testCourse.getInstructorName());

    String newExpected = "Gail Kaiser";
    testCourse.reassignInstructor(newExpected);
    assertEquals(newExpected, testCourse.getInstructorName());
  }

  @Test
  public void getCourseTimeSlotTest() {
    System.out.println("7");
    String expected = "11:40-12:55";
    assertEquals(expected, testCourse.getCourseTimeSlot());

    String newExpected = "10:10-11:25";
    testCourse.reassignTime(newExpected);
    assertEquals(newExpected, testCourse.getCourseTimeSlot());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
}

