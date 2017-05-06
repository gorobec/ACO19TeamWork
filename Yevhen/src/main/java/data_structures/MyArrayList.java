package data_structures;

import exceptions.MyArrayindexOutOfBoundException;
import exceptions.MyIndexOutOfBoundException;

import java.util.Iterator;

/**
 * @author  gorobec on 09.04.17.
 * @since JDK 1.8
 */
public class MyArrayList<T> implements MyList<T>{


    private static final int DEFAULT_CAPACITY = 10;
    private T[] elementData;
    private int size;


    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings(value = "unchecked")
    public MyArrayList(int capacity) {
        elementData = (T[])new Object[capacity];
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
    public boolean add(T o) {

        if(size == elementData.length){
            ensureCapacity();
        }

        elementData[size++] = o;
        return true;
    }
    @SuppressWarnings(value = "unchecked")
    private void ensureCapacity() {
        T[] newElementData = (T[])new Object[2 * size];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    @Override
    public boolean add(T o, int index) {
        return false;
    }

    public T get(int index) {

        return null;
    }

    public T remove(int index) {
        try {
            checkIndex(index);
        } catch (MyArrayindexOutOfBoundException | MyIndexOutOfBoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            throw new RuntimeException();
        }
        T value = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - index - 1);
        size--;
//        remove
//        shift
        return value;
    }

    private void checkIndex(int index) throws MyArrayindexOutOfBoundException {
        if(index < 0 || index  >= size) throw new MyArrayindexOutOfBoundException(String.format("Index; %d", index));
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
    public Iterator<T> iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator<T>{

        int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
           /* Object value = elementData[position];
            position++;
            return value;*/
            return elementData[position++];
        }
    }
}
