package homeWorkWeek3.LinkedList;

/**
 * Created by volodymyrkorniienko on 01.05.17.
 */
public interface MyList {

    boolean add(Object o);
    boolean add(int index, Object o);
    Object get(int index);
    boolean remove(int index);
    boolean remove(Object o);
    void set(int index, Object o);
    void clear();
    boolean contains(Object o);
    int size();
    Node goTo(int index);
}
