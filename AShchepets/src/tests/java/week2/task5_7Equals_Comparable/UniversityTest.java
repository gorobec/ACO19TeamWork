package week2.task5_7Equals_Comparable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 24.04.2017.
 */
public class UniversityTest {

    University testUniversity;

    @Before
    public void setUp() {
        testUniversity = new University();
        testUniversity.setActualGroupQuantity(1);

        testUniversity.getListOfGroups()[0] = new Group();
        testUniversity.getListOfGroups()[0].getStudents()[0] = new Student();
        testUniversity.getListOfGroups()[0].getStudents()[1] = new Student("testName1", "testSurname1");

        testUniversity.getListOfGroups()[0].setActualGroupSize(2);

    }

    @After
    public void tearDown() {

        testUniversity = null;
    }

    @Test
    public void test_add_null() {

        Group testGroup = null;

        Assert.assertFalse(testUniversity.addGroup(testGroup));
    }

    @Test
    public void test_add_same_group() {

        Group testGroup = new Group();
        testGroup.setActualGroupSize(2);

        testGroup.getStudents()[0] = new Student();
        testGroup.getStudents()[1] = new Student("testName1", "testSurname1");

        Assert.assertFalse(testUniversity.addGroup(testGroup));
    }

    @Test
    public void test_add_not_same_group() {

        Group testGroup = new Group();
        testGroup.setActualGroupSize(3);

        testGroup.getStudents()[0] = new Student("testName99","testSurname99");
        testGroup.getStudents()[1] = new Student("testName00", "testSurname00");
        testGroup.getStudents()[2] = new Student("testName11", "testSurname11");

        Assert.assertTrue(testUniversity.addGroup(testGroup));
    }

    @Test
    public void test_add_other_group_with_same_one_student () {

        Group testGroup = new Group();
        testGroup.setActualGroupSize(2);

        testGroup.getStudents()[0] = new Student();
        testGroup.getStudents()[1] = new Student("testName101", "testSurname101");

        Assert.assertTrue(testUniversity.addGroup(testGroup));

    }

}
