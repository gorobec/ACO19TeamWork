package data_structures;

/**
 * Created by gorobec on 22.04.17.
 */
public interface MyCollection {

    boolean add (Object o);
    boolean contains (Object o);
    void clear();
    boolean isEmpty();
    boolean remove(Object o);
    int size();
}
