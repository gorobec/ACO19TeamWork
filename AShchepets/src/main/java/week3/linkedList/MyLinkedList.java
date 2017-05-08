package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList implements MyList {

    private Object head;
    private Object tail;
    private int size;

    public MyLinkedList() {
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean add(Object o, int index) {
        return false;
    }

    @Override
    public boolean addFirst(Object o) {
        return false;
    }

    @Override
    public boolean addLast(Object o) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public Object set(int index, Object o) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }
}
