package data_structures;

public class MyLinkedListTest extends MyListTest {
    @Override
    public void setUp() {
        Object[] array = {null, "StringObject", true, 5, 7.7, null, new Object().toString()};
        myList = new MyLinkedList(array);
    }
}
