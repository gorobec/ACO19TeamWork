package data_structures;

public class MyLinkedListTest extends MyListTest {
    @Override
    public void setUp() {
        String[] array = {null, "StringObject", "true", "5", "7.7", "null", new Object().toString()};
        myList = new MyLinkedList<String>(array);
    }
}
