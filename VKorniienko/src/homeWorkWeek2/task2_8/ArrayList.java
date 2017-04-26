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
        if (!elementData[index].equals(null)) {
            return false;
        }

        if (size == elementData.length){
            ensureCapacity();
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
        if (!elementData[index].equals(null)) {
            return false;
        }

        if (index > size) {
            ensureCapacity();;
        }

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

    public Object set(int index, Object o) {
        if (!elementData[index].equals(null)) return null;

        Object previousElement = elementData[index];
        elementData[index] = o;

        return previousElement;
    }
}
