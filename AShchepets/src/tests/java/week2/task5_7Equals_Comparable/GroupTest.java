package week2.task5_7Equals_Comparable;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 24.04.2017.
 */
public class GroupTest {

    Group testGroup;

    @Before
    public void setUp() {
        testGroup = new Group();

        // делая тесты, которые не будут зависить друг от друга - приходится добавлять студентов вручную,
        // не используя метода add().
        // При ручном добавлении счетчик размера группы не увеличивается, увеличиваем его вручную
        // во избежания ошибок при тестировании

        testGroup.setActualGroupSize(2);

        testGroup.getStudents()[0] = new Student();
        testGroup.getStudents()[1] = new Student("testName1","testSurname1");

    }

    @After
    public void tearDown() {

        testGroup = null;
    }

    @Test
    public void test_add_null() {

        Student testStudent = null;

        Assert.assertFalse(testGroup.addStudent(testStudent));
    }

    @Test
    public void test_add_same_student() {

        Student testStudent = new Student();

        Assert.assertFalse(testGroup.addStudent(testStudent));
    }

    @Test
    public void test_add_other_student() {

        Student testStudent = new Student("testName99", "testSurname99");

        Assert.assertTrue(testGroup.addStudent(testStudent));
    }

}
