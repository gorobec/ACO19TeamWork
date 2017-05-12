package data_structures;

import org.junit.Before;

public class MyArrayListTest extends MyListTest {
    @Before
    public void setUp() {
        String[] array = {null, "StringObject", "true", "5", "7.7", "null", new Object().toString()};
        myList = new MyArrayList<String>(array);
    }

}