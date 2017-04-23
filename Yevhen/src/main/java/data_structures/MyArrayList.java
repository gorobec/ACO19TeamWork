package data_structures;

import java.util.Iterator;

/**
 * @author  gorobec on 09.04.17.
 * @since JDK 1.8
 */
public class MyArrayList implements MyList{


    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int size;


    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        elementData = new Object[capacity];
    }



    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     *
     *
     *
     *
     * */
    public boolean add(Object o) {

        if(size == elementData.length){
            ensureCapacity();
        }

        elementData[size++] = o;
        return true;
    }

    private void ensureCapacity() {
        Object[] newElementData = new Object[2 * size];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    @Override
    public boolean add(Object o, int index) {
        return false;
    }

    public Object get(int index) {

        return null;
    }

    public Object remove(int index) {
//        TODO check index
//        remove
//        shift
        return null;
    }

    @Override
    public boolean set(Object o, int index) {
        return false;
    }

    public boolean remove(Object o) {
//        check null / !null
        return false;
    }

    public void clear() {

    }

    public boolean contains(Object o) {
        return false;
    }

    public void trimToSize(){

    }

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator{

        int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public Object next() {
           /* Object value = elementData[position];
            position++;
            return value;*/
            return elementData[position++];
        }
    }
}
