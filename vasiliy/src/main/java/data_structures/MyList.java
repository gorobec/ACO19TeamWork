package data_structures;

public interface MyList extends MyCollection {
    boolean add(int index, Object o);

    Object get(int index);

    Object remove(int index);

    Object set(int index, Object o);

    int indexOf(Object o);
}
