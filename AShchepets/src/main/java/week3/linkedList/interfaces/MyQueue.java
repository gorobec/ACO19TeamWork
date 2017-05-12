package week3.linkedList.interfaces;

/**
 * Created by SmooZzzie on 11.05.2017.
 */
public interface MyQueue<T> extends MyCollection<T> {
    T element();
    boolean offer(T e);
    T peek();
    T poll();
    T remove();
}
