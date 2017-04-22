package homeWorkWeek2.task2_8;

/**
 * Created by volodymyrkorniienko on 15.04.17.
 */
public class ArrayList {

    private static final int DEFAULT_INITIAL_CAPACITY = 5;
    private Object[] elementData;
    private int size;


    public ArrayList() {
        elementData = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public ArrayList(int capacity) {
        elementData = new Object[capacity];
    }

    public boolean add(Object o) {
        if(size == elementData.length){
            ensureCapacity();
        }
        elementData[size++] = o;
        return true;
    }

    public boolean add(int index, Object o) {
        if (size == elementData.length){
            ensureCapacity();
        }
        if (elementData[index] != null) {
            System.out.println("Index is busy");
            return false;
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = o;
        size++;
        return true;
    }

    private void ensureCapacity() {
        Object[] newElementData = new Object[2 * size];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i] == o) {
                elementData[i] = null;
            }
        }
        return false;
    }

    public boolean remove(int index) {
        int numMover = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMover);
        elementData[size - 1] = null;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public void clearArray() {
        for (int i = 0; i < elementData.length; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    public Object get(int index) {
        return elementData[index];
    }

    public boolean set(int index, Object o) {
        if (elementData[index] != null) {
            System.out.println("Index is busy");
            return false;
        }
        if (elementData[index] == null) {
            if (size >= index) {
                elementData[index] = o;
                return true;
            }
        }
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }
}
