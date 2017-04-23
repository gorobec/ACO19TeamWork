package data_structures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by gorobec on 22.04.17.
 */
public abstract class MyListBaseTest {
    protected MyList myList;

    @Before
    public abstract void setUp();
    @After
    public void tearDown() {
        myList = null;
    }



    @Test
    public void test_add_one_element(){

        boolean actual = myList.add(1);
//        boolean expected = true;

//        assertEquals(expected, actual);

        assertTrue(actual);

    }

    @Test
    public void test_add_eleven_elements(){

        for (int i = 0; i < 11; i++) {

            assertTrue(myList.add(i));
//            assertEquals(i, myList.get(i));
        }

    }
    @Test
    public void size1() {
        int expected = 7;
        int actual = myList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size2() {
        myList.add(null);
        myList.add("String");

        int expected = 9;
        int actual = myList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size3() {
        myList.clear();

        int expected = 0;
        int actual = myList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove1() {
        Object expected = 7.7;
        Object actual = myList.remove(4);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void remove3() {
        Object actual = myList.remove(9);
        Assert.assertNull(actual);
    }
    @Test
    public void isEmpty1() {
        boolean actual = myList.isEmpty();
        Assert.assertFalse(actual);
    }

    @Test
    public void isEmpty2() {
        myList.clear();

        boolean actual = myList.isEmpty();
        Assert.assertTrue(actual);
    }

    @Test
    public void add1() {
        boolean actual = myList.add(null);
        Assert.assertTrue(actual);

        int expectedSize = 1;
        int actualSize = myList.size();
        Assert.assertEquals(expectedSize, actualSize);

        Object actualObj = myList.get(0);
        Assert.assertNull(actualObj);
    }
}
