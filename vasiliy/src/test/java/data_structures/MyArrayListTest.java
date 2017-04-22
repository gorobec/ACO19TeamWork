package data_structures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {

    private MyArrayList myArrayList;

    @Before
    public void setUp() {
        Object[] array = {null, "StringObject", true, 5, 7.7, null, new Object().toString()};
        myArrayList = new MyArrayList(array);
    }

    @After
    public void tearDown() {
        myArrayList = null;
    }

    @Test
    public void size1() {
        int expected = 7;
        int actual = myArrayList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size2() {
        myArrayList.add(null);
        myArrayList.add("String");

        int expected = 9;
        int actual = myArrayList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void size3() {
        myArrayList.clear();

        int expected = 0;
        int actual = myArrayList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf1() {
        int expected = 0;
        int actual = myArrayList.indexOf(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf2() {
        int expected = 1;
        int actual = myArrayList.indexOf("StringObject");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf3() {
        int expected = 3;
        int actual = myArrayList.indexOf(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf4() {
        int expected = -1;
        int actual = myArrayList.indexOf(new Object().toString());
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void clear() {
        myArrayList.clear();

        int expected = 0;
        int actual = myArrayList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains1() {
        boolean actual = myArrayList.contains(null);
        Assert.assertTrue(actual);
    }

    @Test
    public void contains2() {
        boolean actual = myArrayList.contains(6);
        Assert.assertFalse(actual);
    }

    @Test
    public void isEmpty1() {
        boolean actual = myArrayList.isEmpty();
        Assert.assertFalse(actual);
    }

    @Test
    public void isEmpty2() {
        myArrayList.clear();

        boolean actual = myArrayList.isEmpty();
        Assert.assertTrue(actual);
    }

    @Test
    public void add1() {
        boolean actual = myArrayList.add(null);
        Assert.assertTrue(actual);

        int expectedSize = 8;
        int actualSize = myArrayList.size();
        Assert.assertEquals(expectedSize, actualSize);

        Object actualObj = myArrayList.get(7);
        Assert.assertNull(actualObj);
    }

    @Test
    public void add2() {
        boolean actual = myArrayList.add(0, "String");
        Assert.assertTrue(actual);

        Object expectedObj = "StringObject";
        Object actualObj = myArrayList.get(2);
        Assert.assertEquals(expectedObj, actualObj);

        int expectedIndex = 1;
        int actualIndex = myArrayList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void add3() {
        boolean actual = myArrayList.add(7, "String");
        Assert.assertFalse(actual);
    }

    @Test
    public void get1() {
        Object expected = 7.7;
        Object actual = myArrayList.get(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get2() {
        Object actual = myArrayList.get(10);
        Assert.assertNull(actual);
    }

    @Test
    public void remove1() {
        Object expected = 7.7;
        Object actual = myArrayList.remove(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove2() {
        Object actual = myArrayList.remove(0);
        Assert.assertNull(actual);

        int expectedIndex = 4;
        int actualIndex = myArrayList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void remove3() {
        Object actual = myArrayList.remove(9);
        Assert.assertNull(actual);
    }

    @Test
    public void remove4() {
        boolean actual = myArrayList.remove(null);
        Assert.assertTrue(actual);

        int expectedIndex = 4;
        int actualIndex = myArrayList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void remove5() {
        boolean actual = myArrayList.remove("StringObject");
        Assert.assertTrue(actual);

        int expectedSize = 6;
        int actualSize = myArrayList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void remove6() {
        boolean actual = myArrayList.remove("String");
        Assert.assertFalse(actual);
    }

    @Test
    public void set1() {
        Object expected = 5;
        Object actual = myArrayList.set(3, 100);
        Assert.assertEquals(expected, actual);

        Object expectedObject = 100;
        Object actualObject = myArrayList.get(3);
        Assert.assertEquals(expectedObject, actualObject);
    }

    @Test
    public void set2() {
        Object actual = myArrayList.set(0, 100);
        Assert.assertNull(actual);
    }

    @Test
    public void set3() {
        Object actual = myArrayList.set(-5, 100);
        Assert.assertNull(actual);
    }

}