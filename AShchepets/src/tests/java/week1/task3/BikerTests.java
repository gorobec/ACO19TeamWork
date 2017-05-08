package week1.task3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week1.task3.model.Bike;
import week1.task3.model.Biker;

/**
 * Created by SmooZzzie on 11.04.2017.
 */
public class BikerTests {


        Biker testBiker;
        Bike testBike1;

        @Before
        public void setUp() {
                testBiker = new Biker("Vova");
                testBike1 = new Bike("testModel1", false);
        }

        @After
        public void tearDown() {
                testBiker = null;
                testBike1 = null;
        }

        @Test
        public void test_buy_motorcycle(){
           Assert.assertTrue(testBiker.buyMotocycle(testBike1));
        }

        @Test
        public void test_sell_motorcycle() {

                testBiker.setBike(testBike1);

                Assert.assertTrue(testBiker.sellMotorcycle());
        }

        @Test
        public void test_fix_motorcycle() {

                testBiker.setBike(testBike1);

                Assert.assertTrue(testBiker.fixMotorcycle());
        }

}
