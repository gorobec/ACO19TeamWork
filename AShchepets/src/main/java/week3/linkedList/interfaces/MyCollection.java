package week3.linkedList.interfaces;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public interface MyCollection<T> {
    int size();
    boolean add(T o) throws IllegalStateException;
    boolean remove(T o);
    void clear();
    boolean isEmpty();
    boolean contains(Object o);
}
