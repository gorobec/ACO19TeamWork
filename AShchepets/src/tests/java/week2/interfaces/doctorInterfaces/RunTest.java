package week2.interfaces.doctorInterfaces;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by SmooZzzie on 22.04.2017.
 */
public class RunTest {

    Surgeon testSurgeon = new Surgeon("Artem", 55);
    NeuroSurgeon testNeuroSurgeon = new NeuroSurgeon("Vova", 33);

    @Test
    public void test_work_surgeon () {

        int expected = 56;
        testSurgeon.work();
        int actual = testSurgeon.getOverallExperienceAsSurgeon();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test_work_neurosurgeon () {

        int expected = 34;
        testSurgeon.work();
        int actual = testNeuroSurgeon.getExperienceAsNeuroSurgeon();

        Assert.assertEquals(expected,actual);
    }

}
