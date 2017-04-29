package data_structures;

import java.lang.reflect.Array;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] elementData;
    private int size;

    /*public <T> T[] getArray(Class<T> clazz, int size) {
        @SuppressWarnings("unchecked")
        T[] arr = (T[]) Array.newInstance(clazz, size);

        return arr;
    }*/


    public MyArrayList(int capacity) {
        elementData = (T[]) new Object[capacity];
    }

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(T[] array) {
        elementData = array;
        size = elementData.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(T o) {

        if (size == elementData.length) {
            ensureCapacity();
        }
        elementData[size] = o;
        size++;
        return true;
    }

    private void ensureCapacity() {
        T[] newElementData = (T[])new Object[2 * size];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    public boolean add(int index, T o) {
        if (size == elementData.length) {
            ensureCapacity();
        }
        if (!checkIndex(index)) {
            return false;
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = o;
        size++;
        return true;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    public T get(int index) {
        if (!checkIndex(index)) {
            return null;
        }

        return elementData[index];
    }

    public T remove(int index) {
        if (!checkIndex(index)) {
            return null;
        }

        T o = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size - 1] = null;
        size--;
        return o;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean remove(T o) {
        int index = indexOf(o);
        if (!checkIndex(index)) {
            return false;
        }
        remove(index);
        return true;
    }

    public T set(int index, T o) {
        if (!checkIndex(index)) {
            return null;
        }
        T oldObj = elementData[index];
        elementData[index] = o;
        return oldObj;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        return checkIndex(indexOf(o));
    }

    @Override
    public Iterator iterator() {
        return new MyArrayListIterator();
    }

    private class MyArrayListIterator implements Iterator {

        private int position;
        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public T next() {
            return elementData[position++];
        }
    }
}
