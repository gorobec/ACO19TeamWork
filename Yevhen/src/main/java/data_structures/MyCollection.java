package data_structures;

/**
 * Created by gorobec on 22.04.17.
 */
public interface MyCollection<T> extends Iterable<T>{

    boolean add (T o);
    boolean contains (Object o);
    void clear();
    boolean isEmpty();
    boolean remove(T o);
    int size();
}
