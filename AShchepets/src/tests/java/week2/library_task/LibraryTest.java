package week2.library_task;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 28.04.2017.
 */
public class LibraryTest {

    Library library;

    Reader testReader1;
    Reader testReader2;
    Reader testReader3;
    Reader testReader4;

    Edition testEdition1;
    Edition testEdition2;
    Edition testEdition3;
    Edition testEdition4;

    @Before
    public void setUp() {

        library = new Library();

        testReader1 = new Reader("TESTNAME","TESTSURNAME");
        testReader2 = null;
        testReader3 = new Reader("testname3", "testsurname3", true);
        testReader4 = new Reader("testname3", "testsurname3");


        testEdition1 = new Book("TESTNAME",0000,"TESTNAME",BookGenre.ENCYCLOPEDIA);
        testEdition2 = new Periodical("TESTNAME",1111,4,PeriodicalType.COMICS,Periodicity.MONTHLY);
        testEdition3 = null;
        testEdition4 = new Book("testName", 1111, 0, "testAuthor", BookGenre.ENCYCLOPEDIA);


    }

    @After
    public void tearDown() {

        library = null;
        testReader1 = null;
    }

    @Test
    public void test_add_null_reader_to_library() {
        Assert.assertFalse(library.addReader(testReader2));
    }

    @Test
    public void test_add_normal_reader_to_library() {
        Assert.assertTrue(library.addReader(testReader1));
    }

    @Test
    public void test_add_same_reader_to_library() {

        library.getReadersList().add(testReader1);
        Assert.assertFalse(library.addReader(testReader1));
    }

    @Test
    public void test_add_null_edition_to_library() {
        Assert.assertFalse(library.addEdition(testEdition3));
    }

    @Test
    public void test_add_normal_book__to_library() {
        Assert.assertTrue(library.addEdition(testEdition1));
    }

    @Test
    public void test_add_normal_periodical_to_library() {
        Assert.assertTrue(library.addEdition(testEdition2));
    }

    @Test
    public void test_add_same_book_to_library() {

        library.getEditionsList().add(testEdition1);
        Assert.assertFalse(library.addEdition(testEdition1));
    }

    @Test
    public void test_add_to_banned_reader_edition_not_from_library() {
        library.getReadersList().add(testReader3);

        Assert.assertFalse(library.addEditionToReader(testEdition1, testReader3));
    }

    @Test
    public void test_add_to_reader_not_from_library_normal_edition() {

        library.getEditionsList().add(testEdition1);

        Assert.assertFalse(library.addEditionToReader(testEdition1, testReader4));
    }

    @Test
    public void test_add_to_normal_reader_edition_with_zero_quantity() {

        library.getReadersList().add(testReader4);
        library.getEditionsList().add(testEdition4);

        Assert.assertFalse(library.addEditionToReader(testEdition4, testReader4));
    }

    @Test
    public void test_add_to_normal_reader_normal_edition() {

        library.getEditionsList().add(testEdition2);
        library.getReadersList().add(testReader4);

        Assert.assertTrue(library.addEditionToReader(testEdition2, testReader4));
    }

    @Test
    public void test_add_to_black_list() {

        library.getReadersList().add(testReader4);

        Assert.assertTrue(library.addReaderToTheBlackList(testReader4));
    }

    @Test
    public void test_add_already_banned_to_black_list() {
        library.getReadersList().add(testReader3);

        Assert.assertFalse(library.addReaderToTheBlackList(testReader3));
    }
}
