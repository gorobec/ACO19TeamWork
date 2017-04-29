package data_structures;

public interface MyCollection<T> extends Iterable<T> {
    boolean add(T o);

    boolean contains(Object o);

    void clear();

    boolean isEmpty();

    boolean remove(T o);

    int size();
}

