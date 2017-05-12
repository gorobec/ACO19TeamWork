package week4.binarySearch;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week2.task5_7Equals_Comparable.Group;
import week2.task5_7Equals_Comparable.Student;
import week2.task5_7Equals_Comparable.StudentComparator;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public class BinarySearchTest {

    Group testGroup1 = new Group("test", 5);

    Student testStudent1 = new Student("testName11", "testSurname11");
    Student testStudent2 = new Student("testName12", "testSurname12");
    Student testStudent3 = new Student("testName13", "testSurname13");
    Student testStudent4 = new Student("testName14", "testSurname14");
    Student testStudent5 = new Student("testName15", "testSurname15");

    @Before
    public void setUp() {
        testGroup1.addStudent(testStudent3);
        testGroup1.addStudent(testStudent5);
        testGroup1.addStudent(testStudent2);
        testGroup1.addStudent(testStudent4);
        testGroup1.addStudent(testStudent1);
    }

    @After
    public void tearDown() {
        testGroup1 = null;
    }

    @Test
    public void test_binary_search() {
        Assert.assertTrue(BinarySearch.contains(testGroup1.getStudents(),testStudent5));
    }

    @Test
    public void test_binary_search_2() {
        Assert.assertFalse(BinarySearch.contains(testGroup1.getStudents(), new Student("Artem","Shchepets")));
    }

    @Test
    public void test_binary_search_with_comparator() {
        Assert.assertTrue(BinarySearch.contains(testGroup1.getStudents(),testStudent2,new StudentComparator()));
    }

    @Test
    public void test_binary_search_with_comparator_2() {
        Assert.assertFalse(BinarySearch.contains(testGroup1.getStudents(),
                new Student("Artem","shchepets"),new StudentComparator()));
    }
}
