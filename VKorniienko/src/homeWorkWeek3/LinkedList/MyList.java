package homeWorkWeek3.LinkedList;

/**
 * Created by volodymyrkorniienko on 01.05.17.
 */
public interface MyList<T> {

    boolean add(T o);
    boolean add(int index, T o);
    T get(int index);
    boolean remove(int index);
    boolean remove(T o);
    void set(int index, T o);
    void clear();
    boolean contains(T o);
    int size();
}
