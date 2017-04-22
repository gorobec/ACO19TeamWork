package week1.home1;

import org.junit.Assert;
import org.junit.Test;

public class ContactTest {
    @Test
    public void isLife1() throws Exception {
        Contact contact = new Contact();
        contact.init("Name1","0631234567");

        boolean expected = true;
        boolean actual = contact.isLife();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isLife2() throws Exception {
        Contact contact = new Contact();
        contact.init("Name1","0501234567");

        boolean expected = false;
        boolean actual = contact.isLife();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isKievStar1() throws Exception {
        Contact contact = new Contact();
        contact.init("Name1","0981234567");

        boolean expected = true;
        boolean actual = contact.isKievStar();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isKievStar2() throws Exception {
        Contact contact = new Contact();
        contact.init("Name1","0501234567");

        boolean expected = false;
        boolean actual = contact.isKievStar();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void init1(){
        Contact contact = new Contact();

        boolean expected = true;
        boolean actual = contact.init("Name1","0501234567");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void init2(){
        Contact contact = new Contact();

        boolean expected = false;
        boolean actual = contact.init("Name1","050123456");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validatePhone1() {
        Contact contact = new Contact();

        boolean expected = true;
        boolean actual = contact.validatePhone("0501234567");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validatePhone2() {
        Contact contact = new Contact();

        boolean expected = false;
        boolean actual = contact.validatePhone("050f234567");
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void validatePhone3() {
        Contact contact = new Contact();

        boolean expected = false;
        boolean actual = contact.validatePhone("05012345678");
        Assert.assertEquals(expected, actual);
    }
}