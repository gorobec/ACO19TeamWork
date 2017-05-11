package week3.linkedList.interfaces;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public interface MyCollection<T> {
    int size();
    boolean checkIndex(int index);
    boolean add(T o);
    boolean remove(T o);
    void clear();
    boolean isEmpty();
    boolean contains(Object o);
}
