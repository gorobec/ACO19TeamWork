package data_structures;

/**
 * Created by gorobec on 22.04.17.
 */
public interface MyList extends MyCollection {
    boolean add(Object o, int index);
    Object get(int index);
    Object remove(int index);
    boolean set(Object o, int index);


}
