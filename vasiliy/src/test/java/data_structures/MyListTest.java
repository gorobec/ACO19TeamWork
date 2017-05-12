package data_structures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class MyListTest {
    protected MyList<String> myList;

    @Before
    public abstract void setUp();

    @After
    public void tearDown() {
        myList = null;
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
    public void indexOf1() {
        int expected = 0;
        int actual = myList.indexOf(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf2() {
        int expected = 1;
        int actual = myList.indexOf("StringObject");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf3() {
        int expected = 3;
        int actual = myList.indexOf("5");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexOf4() {
        int expected = -1;
        int actual = myList.indexOf(new Object().toString());
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void clear() {
        myList.clear();

        int expected = 0;
        int actual = myList.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void contains1() {
        boolean actual = myList.contains(null);
        Assert.assertTrue(actual);
    }

    @Test
    public void contains2() {
        boolean actual = myList.contains("6");
        Assert.assertFalse(actual);
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

        int expectedSize = 8;
        int actualSize = myList.size();
        Assert.assertEquals(expectedSize, actualSize);

        Object actualObj = myList.get(7);
        Assert.assertNull(actualObj);
    }

    @Test
    public void add2() {
        boolean actual = myList.add(0, "String");
        Assert.assertTrue(actual);

        Object expectedObj = "StringObject";
        Object actualObj = myList.get(2);
        Assert.assertEquals(expectedObj, actualObj);

        int expectedIndex = 1;
        int actualIndex = myList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void add3() {
        boolean actual = myList.add(7, "String");
        Assert.assertFalse(actual);
    }

    @Test
    public void get1() {
        Object expected = "7.7";
        Object actual = myList.get(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void get2() {
        Object actual = myList.get(10);
        Assert.assertNull(actual);
    }

    @Test
    public void remove1() {
        Object expected = "7.7";
        Object actual = myList.remove(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void remove2() {
        Object actual = myList.remove(0);
        Assert.assertNull(actual);

        int expectedIndex = -1;
        int actualIndex = myList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void remove3() {
        Object actual = myList.remove(9);
        Assert.assertNull(actual);
    }

    @Test
    public void remove4() {
        boolean actual = myList.remove(null);
        Assert.assertTrue(actual);

        int expectedIndex = -1;
        int actualIndex = myList.indexOf(null);
        Assert.assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void remove5() {
        boolean actual = myList.remove("StringObject");
        Assert.assertTrue(actual);

        int expectedSize = 6;
        int actualSize = myList.size();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void remove6() {
        boolean actual = myList.remove("String");
        Assert.assertFalse(actual);
    }

    @Test
    public void remove7() {
        Object expectedObject = myList.get(myList.size()-1);
        Object actualObject = myList.remove(myList.size()-1);
        Assert.assertEquals(expectedObject, actualObject);

        int expectedSize = 6;
        int actualSize = myList.size();
        Assert.assertEquals(expectedSize, actualSize);

        Object expected = "null";
        Object actual = myList.get(5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void set1() {
        Object expected = "5";
        Object actual = myList.set(3, "100");
        Assert.assertEquals(expected, actual);

        Object expectedObject = "100";
        Object actualObject = myList.get(3);
        Assert.assertEquals(expectedObject, actualObject);
    }

    @Test
    public void set2() {
        Object actual = myList.set(0, "100");
        Assert.assertNull(actual);
    }

    @Test
    public void set3() {
        Object actual = myList.set(-5, "100");
        Assert.assertNull(actual);
    }
}
