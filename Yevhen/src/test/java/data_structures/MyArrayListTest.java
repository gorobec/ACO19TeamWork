package data_structures;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gorobec on 09.04.17.
 */
public class MyArrayListTest {
    MyArrayList myArrayList;

    @Before
    public void setUp() {
        myArrayList = new MyArrayList();
    }
    @After
    public void tearDown() {
        myArrayList = null;
    }



    @Test
    public void test_add_one_element(){

        boolean actual = myArrayList.add(1);
//        boolean expected = true;

//        assertEquals(expected, actual);

        assertTrue(actual);

    }

    @Test
    public void test_add_eleven_elements(){

        for (int i = 0; i < 11; i++) {

            assertTrue(myArrayList.add(i));
//            assertEquals(i, myArrayList.get(i));
        }

    }

}