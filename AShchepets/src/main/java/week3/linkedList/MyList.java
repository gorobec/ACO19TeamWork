package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public interface MyList<T> {

    int size();
    boolean checkIndex(int index);
    boolean add(T o);
    boolean add(T o, int index);
    boolean addFirst(T o);
    boolean addLast(T o);
    T get(int index);
    boolean remove(int index);
    boolean remove(T o);
    boolean removeLast();
    boolean removeFirst();
    T set(int index, T o);
    void clear();
    boolean isEmpty();
    boolean contains(Object o);

}
