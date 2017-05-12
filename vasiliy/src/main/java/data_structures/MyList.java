package data_structures;

public interface MyList<T> extends MyCollection<T> {
    boolean add(int index, T o);

    T get(int index);

    T remove(int index);

    T set(int index, T o);

    int indexOf(T o);
}
