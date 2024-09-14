package dev.coms4156.project.individualproject;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;

@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  @BeforeEach
  public void setupDepartmentForTesting() {
    courses.put("test1234", new Course("Griffin Newbold",
            "417 IAB", "11:40-12:55", 250));
    testDepartment = new Department("TEST", courses,
            "Lee Bollinger", 500);
  }

  @Test
  public void getNumberOfMajorsTest() {
    int expected = 500;
    assertEquals(expected, testDepartment.getNumberOfMajors());
  }

  @Test
  public void getDepartmentChairTest() {
    String expected = "Lee Bollinger";
    assertEquals(expected, testDepartment.getDepartmentChair());
  }

  @Test
  public void getCourseSelectionTest() {
    HashMap<String, Course> actual = testDepartment.getCourseSelection();
    assertEquals(courses, actual);
  }

  @Test
  public void addPersonToMajorTest() {
    int numMajors = testDepartment.getNumberOfMajors();
    testDepartment.addPersonToMajor();
    assertEquals(numMajors + 1, testDepartment.getNumberOfMajors());
  }

  @Test
  public void dropPersonFromMajorTest() {
    int numMajors = testDepartment.getNumberOfMajors();
    testDepartment.dropPersonFromMajor();
    assertEquals(numMajors - 1, testDepartment.getNumberOfMajors());
  }

  @Test
  public void createCourseTest() {
    testDepartment.createCourse("test6789", "Larry Davis",
            "301 Uris", "2:40-3:55", 150);
    courses.put("test6789", new Course("Larry Davis",
            "301 Uris", "2:40-3:55", 150));
    assertEquals(courses, testDepartment.getCourseSelection());
  }

  @Test
  public void toStringTest() {
    String expectedResult = "TEST test1234: \nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55\n"
            + "TEST test6789: \nInstructor: Larry Davis; Location: 301 Uris; Time: 2:40-3:55\n";
    assertEquals(expectedResult, testDepartment.toString());
  }




  public static HashMap<String, Course> courses = new HashMap<>();
  /** The test course instance used for testing. */
  public static Department testDepartment;

}

