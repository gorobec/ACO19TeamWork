package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public interface MyList {

    int size();
    boolean checkIndex(int index);
    boolean add(Object o);
    boolean add(Object o, int index);
    boolean addFirst(Object o);
    boolean addLast(Object o);
    Object get(int index);
    boolean remove(int index);
    boolean remove(Object o);
    boolean removeLast();
    boolean removeFirst();
    Object set(int index, Object o);
    void clear();
    boolean isEmpty();
    boolean contains(Object o);

}
