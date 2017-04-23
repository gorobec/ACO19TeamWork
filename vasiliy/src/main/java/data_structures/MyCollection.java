package data_structures;

public interface MyCollection extends Iterable {
    boolean add(Object o);

    boolean contains(Object o);

    void clear();

    boolean isEmpty();

    boolean remove(Object o);

    int size();
}

