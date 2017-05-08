package week2.my_array_list;

/**
 * Created by SmooZzzie on 26.04.2017.
 */
public class MyArrayList {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData;
    private int actualSize;

    public MyArrayList() {

        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {

        this.elementData = new Object[capacity];
    }

    public MyArrayList(Object[] data) {
        this.elementData = data;
        actualSize = data.length;
    }

    public Object[] getElementData() {
        return elementData;
    }

    /*
        * Method trimToSize() leads to an actual size without excess empty cells
        *
        * @param None
        * @return None
         */
    public void trimToSize() {

        Object[] newElementData = new Object[actualSize];
        System.arraycopy(elementData, 0, newElementData, 0, actualSize);
        elementData = newElementData;
    }

    /*
    * Method size() return a number of elements in you ArrayList
    *
    * @param None
    * @return an int value of ArrayList's actual size(number of elements in ArrayList)
     */
    public int size() {

        return actualSize;
    }

    /*
    * Method checkIndex() checking for index's coming out of elementsData[] bounds
    *
    * @param index that should be checked
    * @return boolean value if index is out of the bounds or not
     */
    private boolean checkIndex(int checkingIndex) {
        return checkingIndex >= 0 && checkingIndex < actualSize;
    }

    /*
    * Method isEmpty() checking for emptiness of elementData[]
    *
    * @param None
    * @return boolean value --- if elementData is empty returns "true", otherwise - "false"
     */
    public boolean isEmpty() {

        return actualSize == 0;
    }

    /*
    * Adding an object to the ElementData[]. Firstly checks if elementData[] is filled.
    * If so - calling a method ensureCapacity(), which expands elementData[] doubly.
    * Then save an object in last free cell of ElementData[]
    * and increments an actual size of ElementData[](number of elements).
    *
    * @param an object that you want to add
    * @return boolean value if an object was saved in last free cell or not
     */
    public boolean add(Object o) {

        if (actualSize == elementData.length) {
            ensureCapacity();
        }

        elementData[actualSize++] = 0;
        return true;
    }

    /*
    * Expand elementData[] doubly. Firstly, creating additional Object[], which has a doubled size and
    * in which source elementData[] will be copied.
    * Then with the help of native method arraycopy() copies a data to the additional Object[]
    * and assigns an additional Object[] to the sourced elementData[].
    *
    * @param None
    * @return None
     */
    public void ensureCapacity() {
        Object[] newElementData = new Object[actualSize * 2];
        System.arraycopy(elementData, 0, newElementData, 0, actualSize);

        elementData = newElementData;
    }

    /*
     * Adding an object to the ElementData[] by index. Firstly checks for index's coming out of elementsData[] bounds,
     * then - if elementData[] is filled. If so - calling a method ensureCapacity(),
     * which expands elementData[] doubly.
     * Then copy all right from the needed index elements,
     * increase an actual size of the elementData[] and record an object to a needed cell.
     *
     * @param a position where you want to write you data, an object that you want to add
     * @return boolean value if an object was saved or not
     */
    public boolean add(int index, Object o) {

        if (!checkIndex(index)) return false;

        if (actualSize == elementData.length) ensureCapacity();

        System.arraycopy(elementData, index, elementData, index + 1, actualSize - index);
        elementData[index] = o;
        actualSize++;

        return true;
    }

    /*
    * Method returns an object that you want to get by index from your elementData[].
    * Firstly, checking for index's coming out of elementsData[] bounds. If true -- return needed element.
    *
    * @param index of the needed element
    * @return needed object
     */

    public Object get(int index) {

        if (!checkIndex(index)) return null;

        return elementData[index];
    }

    /*
    * Removing an element from elementData[] by index. Firstly, checking an index and for emptiness of elementData[].
    * Then delete needed element and do a shift for all right elements.
    * Delete last element and decrease actual size of elementData[].
    *
    * @param an index of removing element
    * @return boolean value if an element was removed or not
     */
    public Object remove(int index) {

        if (isEmpty() || !checkIndex(index)) return null;

        Object oldElement = elementData[index];

        elementData[index] = null;
        System.arraycopy(elementData, index + 1, elementData, index, actualSize - index - 1);
        elementData[actualSize-- - 1] = null;

        return oldElement;
    }

    /*
    * Removing an element from elementData[] by an object. Firstly, checking for emptiness of elementData[].
    * Then delete needed element and do a shift for all right elements.
    * Delete last element and decrease actual size of elementData[].
    *
    * @param removing object
    * @return boolean value if an element was removed or not
     */
    public boolean remove(Object o) {

        if (isEmpty()) return false;

        if (o == null) {
            for (int index = 0; index < actualSize; index++)
                if (elementData[index] == null) {
                    delete(index);
                    return true;
                }
        } else {
            for (int index = 0; index < actualSize; index++)
                if (o.equals(elementData[index])) {
                    delete(index);
                    return true;
                }
        }
        return false;
    }


    public void delete(int index) {
        int numMoved = actualSize - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                    numMoved);
        elementData[--actualSize] = null;
    }
    /*
    * Replaces an element from elementData[] to the new element by index.
    * Firstly, checking an index. Then creates an additional object and assigns elementData[index] to it.
    * Assigns to the old element the new one and return an old object.
    *
    * @param an index of replaced element, replacing object
    * @return a previous element
     */
    public Object set(int index, Object o) {

        if (!checkIndex(index)) return null;

        Object previousObject = elementData[index];
        elementData[index] = o;

        return previousObject;
    }


    /*
    * Clear an elementData[] from all elements. Reset number of elements(actual size).
    *
    * @param None
    * @return None
     */
    public void clear() {

        for (int i = 0; i < actualSize; i++) {
            elementData[i] = null;
        }

        actualSize = 0;
    }

    /*
    * Check for presence of specific object in elementData[].
    *
    * @param searching object
    * @return boolean value if elementData[] contains searching object or not
     */
    public boolean contains(Object o) {

        if (isEmpty()) return false;

        for (int i = 0; i < actualSize; i++) {
            if ((elementData[i] == null && o == null) || elementData[i].equals(o)) return true;
        }

        return false;
    }
}

