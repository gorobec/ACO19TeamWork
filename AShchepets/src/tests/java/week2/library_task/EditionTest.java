package week2.library_task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SmooZzzie on 27.04.2017.
 */
public class EditionTest {

    Edition testEdition1;
    Edition testEdition2;
    Reader testReader1;
    Reader testReader2;
    Reader testReader3;

    @Before
    public void setUp() {

        testEdition1 = new Book("TESTNAME",0000,"TESTNAME",BookGenre.ENCYCLOPEDIA);
        testEdition2 = new Book("testName1", 1111, 0, "testAuthor", BookGenre.RELIGIOUS);

        testReader1 = null;
        testReader2 = new Reader("testName", "testSurname");
        testReader3 = new Reader("TestName2", "testSurname2", true);
    }

    @After
    public void tearDown() {
        testEdition1 = null;
        testEdition2 = null;

        testReader2 = null;
        testReader3 = null;
    }

    @Test
    public void test_add_null_reader_to_edition() {
        Assert.assertFalse(testEdition1.addReader(testReader1));
    }

    @Test
    public void test_add_normal_reader_to_edition () {
        Assert.assertTrue(testEdition1.addReader(testReader2));
    }

    @Test
    public void test_add_banned_reader_to_edition() {
        Assert.assertFalse(testEdition1.addReader(testReader3));
    }

    @Test
    public void test_add_normal_reader_to_edition_with_zero_quantity() {
        Assert.assertFalse(testEdition2.addReader(testReader2));
    }

}