package week3.linkedList.interfaces;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public interface MyList<T> extends MyCollection<T> {

    boolean add(T o, int index);
    boolean addFirst(T o);
    boolean addLast(T o);
    T get(int index);
    boolean remove(int index);
    boolean removeLast();
    boolean removeFirst();
    T set(int index, T o);

}
