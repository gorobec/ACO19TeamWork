package week2.library_task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 28.04.2017.
 */
public class ReaderTest {

    Reader testReader;
    Edition testEdition;
    Reader testReader2;
    Edition testEdition2;

    @Before
    public void setUp() {

        testReader = new Reader("TESTNAME", "TESTSURNAME");
        testEdition = new Book("TESTNAME",0000,"TESTNAME",BookGenre.ENCYCLOPEDIA);

        testReader2 = new Reader("testName", "testSurname", true);
        testEdition2 = null;
    }

    @After
    public void tearDown() {
        testReader = null;
        testEdition = null;
        testReader2 = null;
    }

    @Test
    public void test_add_to_banned_reader_normal_edition() {


        Assert.assertFalse(testReader2.addEdition(testEdition));
    }

    @Test
    public void test_add_to_banned_reader_null_edition() {
        Assert.assertFalse(testReader2.addEdition(testEdition2));
    }

    @Test
    public void test_add_to_not_banned_reader_normal_edition() {
        Assert.assertTrue(testReader.addEdition(testEdition));
    }

    @Test
    public void test_add_to_not_banned_reader_null_edition() {
        Assert.assertFalse(testReader.addEdition(testEdition2));
    }

}
