package week2.interfaces.booksInterfaces;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SmooZzzie on 22.04.2017.
 */
public class RunTest {


    Encyclopedia testBook1 = new Encyclopedia("testEncyclopedia", 300, "Encyclopedia",
            300, 5, "testEdition", 2002);

    ReferenceBook testBook2 = new ReferenceBook("testReferenceBook", 150, "RefBook",
            140, 2, "testEdition2", 1998);

    @Test
    public void test_encyclopedia_buy() {
        int expected = 4;

        //own encyclopedia's method
        testBook1.buy();
        int actual = testBook1.getQuantityOfBooks();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_encyclopedia_read() {

        // method which extended from Book Class
        Assert.assertTrue(testBook1.read());
    }

    @Test
    public void test_reference_book_buy() {
        int expected = 1;

        testBook2.buy();
        int actual = testBook2.getQuantityOfBooks();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_reference_book_read() {

        Assert.assertTrue(testBook2.read());
    }

}
