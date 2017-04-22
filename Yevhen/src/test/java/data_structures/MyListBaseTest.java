package data_structures;

import org.junit.After;
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
}
