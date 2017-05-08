package week3.day1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week2.library_task.Reader;

/**
 * Created by SmooZzzie on 29.04.2017.
 */
public class BinarySearchTest {

        Comparable[]array;
        Reader testReader1;


    @Before
    public void setUp() {
        array = new Reader[7];
        testReader1 = new Reader("TESTNAME","TESTSURNAME");
    }

    @After
    public void tearDown() {
        array = null;
        testReader1 = null;
    }

    @Test
    public void test_binary_search() {
        array[0] = new Reader("Artem");
        array[1] = new Reader("Vasia");
        array[2] = new Reader("Dima");
        array[3] = new Reader("Anton");
        array[4] = testReader1;
        array[5] = new Reader("Anya");
        array[6] = new Reader("Vova");


       Assert.assertTrue(BinarySearch.contains(array,testReader1));
    }
}
