package week3.Iterator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class ProductTest {

    Hotline hotline;
    Repka repka;
    Rozetka rozetka;

    Product testProduct1;
    Product testProduct2;
    Product testProduct3;
    Product testProduct4;
    Product testProduct5;
    Product testProduct6;
    Product testProduct7;
    Product testProduct8;

    @Before
    public void setUp() {
        hotline = new Hotline(10);
        repka = new Repka(10);
        rozetka = new Rozetka(10);

        testProduct1 = new Product("testProduct1", 10);
        testProduct2 = new Product("testProduct2", 11);
        testProduct3 = new Product("testProduct3", 12);
        testProduct4 = new Product("testProduct4", 13);
        testProduct5 = new Product("testProduct5", 14);
        testProduct6 = new Product("testProduct6", 15);
        testProduct7 = new Product("testProduct7", 16);
        testProduct8 = null;
    }

    @After
    public void tearDown () {
        hotline = null;
        repka = null;
        rozetka = null;
    }

    @Test
    public void test_add_to_rozetka() {
        Assert.assertTrue(rozetka.addProduct(testProduct1));
    }

    @Test
    public void test_add_to_rozetka_null () {
        Assert.assertFalse(rozetka.addProduct(testProduct8));
    }

    @Test
    public void test_add_to_repka() {
        Assert.assertTrue(repka.addProduct(testProduct2));
    }

    @Test
    public void test_add_to_repka_null() {
        Assert.assertFalse(repka.addProduct(testProduct8));
    }

    // лень запихивать в репку\розетку напрямую
    @Test
    public void test_add_to_hotline() {

        repka.addProduct(testProduct1);
        repka.addProduct(testProduct4);
        repka.addProduct(testProduct2);

        rozetka.addProduct(testProduct3);
        rozetka.addProduct(testProduct5);
        rozetka.addProduct(testProduct6);
        rozetka.addProduct(testProduct7);

        boolean addFromRozetka = hotline.addProduct(rozetka);
        boolean addFromRepka = hotline.addProduct(repka);

        System.out.println(hotline);
        Assert.assertTrue(addFromRepka && addFromRozetka);
    }
}
