package week1.task3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week1.task3.model.Bike;
import week1.task3.model.Parking;

/**
 * Created by SmooZzzie on 11.04.2017.
 */
public class ParkingTests {

    Parking testParking;
    Bike testBike1;

    @Before
    public void setUp() {
        testParking = new Parking("testStreet, 12", true);

        testBike1 = new Bike("testModel1");

        testParking.getParkedBikes()[0] = testBike1;

    }


    @After
    public void tearDown() {
        testParking = null;
        testBike1 = null;
    }

    @Test
    public void test_add_moto_on_last_free_place() {

        Bike testBike2 = new Bike("testModel2");

        Assert.assertTrue(testParking.addMotoOnLastFreePlace(testBike2));
    }

    @Test
    public void test_add_moto_by_place_number() {

        Bike testBike3 = new Bike("testModel3");

        Assert.assertTrue(testParking.addMotoByPlaceNumber(9, testBike3));

    }

    @Test
    public void test_take_last_moto() {

        Assert.assertTrue(testParking.takeLastMoto());
    }

    @Test
    public void test_take_moto_by_place_number() {

        testParking.getParkedBikes()[6] = new Bike("testModel4");

        // index - 6, but place on parking is 7th
        Assert.assertTrue(testParking.takeMotoByPlaceNumber(7));
    }

    @Test
    public void test_clear_garage() {

        Assert.assertTrue(testParking.clearGaragePlaces());
    }

    @Test
    public void test_open() {
        boolean expected = true;

        testParking.open();
        boolean actual = testParking.isOpened();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void test_close() {
        boolean expected = false;

        testParking.close();
        boolean actual = testParking.isOpened();

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test_change_address() {
        String expected = "newTestAddress";

        testParking.changeAddress("newTestAddress");

        String actual = testParking.getAddress();

        Assert.assertEquals(actual,expected);
    }

}
