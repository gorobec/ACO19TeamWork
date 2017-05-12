package week3.linkedList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class LinkedListTest {

    MyLinkedList testLinkedList;
    MyLinkedList testLinkedListRestricted;
    MyLinkedList testLinkedListEmpty;

   Object testNode1;
    Object testNode2;
    Object testNode3;
    Object testNode4;
    Object testNode5;

    @Before
    public void setUp() {

        testNode1 = "String";
        testNode2 = 5;
        testNode3 =true;
        testNode4 = null;
        testNode5 = 33.55;

        Object[] testArray = {testNode1, testNode2, testNode3, testNode4, testNode5};

        testLinkedList = new MyLinkedList(testArray);
        testLinkedListRestricted = new MyLinkedList(5);
        testLinkedListEmpty = new MyLinkedList();

        testLinkedListRestricted.add(testNode1);
        testLinkedListRestricted.add(testNode2);
        testLinkedListRestricted.add(testNode3);
        testLinkedListRestricted.add(testNode4);
        testLinkedListRestricted.add(testNode5);

    }

    @After
    public void tearDown() {

        testLinkedList = null;
    }

    @Test
    public void test_size() {

        int expected = 5;
        int actual = testLinkedList.size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test_is_empty() {

        Assert.assertFalse(testLinkedList.isEmpty());
    }

    @Test
    public void test_add_by_object() {

        Assert.assertTrue(testLinkedList.add(5));
    }

    @Test
    public void test_add_by_index() {

        Assert.assertTrue(testLinkedList.add(4.55, 3));
    }

    @Test
    public void test_get() {

        Boolean expected = true;
        Assert.assertEquals(expected, testLinkedList.get(2));
    }

    @Test
    public void test_remove_by_index() {

        int expectedSize = 4;

        testLinkedList.remove(2);
        Assert.assertEquals(expectedSize, testLinkedList.size());
    }

    @Test
    public void test_remove_by_object() {

        boolean expected = true;

        Assert.assertEquals(expected, testLinkedList.remove(null));
    }

    @Test
    public void test_set() {

        Object expected = 5;

        Assert.assertEquals(testLinkedList.set(1,"TestSetting"), expected);
    }

    @Test
    public void test_clear() {

        int expectedSize = 0;

        testLinkedList.clear();
        int actual = testLinkedList.size();

        Assert.assertEquals(expectedSize,actual);
    }


    @Test
    public void test_remove_null() {
        int expected_size = 4;
        testLinkedList.remove(null);
        int actual_size = testLinkedList.size();
        Assert.assertEquals(expected_size,actual_size);
    }

    @Test
    public void test_contains_null() {
        boolean expected = true;
        boolean actual = testLinkedList.contains(null);

        Assert.assertEquals(expected,actual);
    }

    /***************TESTS FOR DEQUE********************/

    @Test
    public void test_add_first() {

        Object testObj = false;
        testLinkedList.addFirst(testObj);

        int expectedSize = 6;
        int actualSize = testLinkedList.size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void test_add_last() {

        Object testObj = true;
        testLinkedList.addLast(testObj);

        int expectedSize = 6;
        int actualSize = testLinkedList.size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void test_remove_first() {

        testLinkedList.removeFirst();

        int expectedSize = 4;
        int actualSize = testLinkedList.size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    @Test
    public void test_remove_last() {

        testLinkedList.removeLast();

        int expectedSize = 4;
        int actualSize = testLinkedList.size();

        Assert.assertEquals(expectedSize,actualSize);
    }

    public void test_element() {

        Object actual = testLinkedList.element();
        Object expected = testLinkedList.get(0);

        Assert.assertEquals(expected,actual);
    }

    public void test_get_first() {
        Object actual = testLinkedList.getFirst();
        Object expected = testLinkedList.get(0);

        Assert.assertEquals(expected,actual);
    }

    public void test_offer() {

        Assert.assertTrue(testLinkedList.offer(19));
    }

    public void test_offer_restricted() {
        Assert.assertFalse(testLinkedListRestricted.offer(19));
    }

    public void test_get_last() {
        Object expected = testLinkedList.get(4);
        Object actual = testLinkedList.getLast();

        Assert.assertEquals(expected,actual);
    }

    public void test_peek_empty() {
        Object expected = null;
        Object actual = testLinkedListEmpty.peek();

        Assert.assertEquals(expected,actual);
    }

    public void test_peek() {
        Object expected = testLinkedList.get(0);
        Object actual = testLinkedList.peek();

        Assert.assertEquals(expected,actual);
    }

    public void poll() {

    }


}
