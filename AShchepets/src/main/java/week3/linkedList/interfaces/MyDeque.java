package week3.linkedList.interfaces;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public interface MyDeque<T> extends MyQueue<T> {
    void addFirst(T e);
    void addLast(T e);
    T getFirst();
    T getLast();
    boolean offerFirst(T e);
    boolean offerLast(T e);
    T peekFirst();
    T peekLast();
    T pollFirst();
    T pollLast();
    void push(T e);
    boolean removeFirst();
    boolean removeLast();
}
