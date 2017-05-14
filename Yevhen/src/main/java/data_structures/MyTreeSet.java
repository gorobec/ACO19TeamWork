package data_structures;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class MyTreeSet<T> implements MyNavigableSet<T> {

    private Node<T> root;
    private Comparator<? super T> comparator;
    private int size;

    public MyTreeSet() {
    }

    public MyTreeSet(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(T o) {

        if(root == null) {
            if(o == null) throw new NullPointerException();
            root = new Node<>(o);
        }
        if(comparator == null) {
            Comparable<T> obj = (Comparable<T>) o;
            Node<T> current = root;
            Node<T> parent = null;
            int sideIdx = 0;
            while (current != null) {
                parent = current;
                sideIdx = obj.compareTo(current.value);
                if (sideIdx == 0){
                    return false;
                } else if(sideIdx > 0){
                    current = current.rightChild;
                } else {
                    current = current.leftChild;
                }
            }
            current = new Node<>(o);
            if(sideIdx > 0){
                parent.rightChild = current;
            } else {
                parent.leftChild = current;
            }
            current.parent = parent;
        } else {
//            Todo comparator add
        }
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(T o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T lower(T t) {
        return null;
    }

    @Override
    public T floor(T t) {
        return null;
    }

    @Override
    public T ceiling(T t) {
        return null;
    }

    @Override
    public T higher(T t) {
        return null;
    }

    @Override
    public T pollFirst() {
        return null;
    }

    @Override
    public T pollLast() {
        return null;
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public T first() {
        return null;
    }

    @Override
    public T last() {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private static class Node<T>{
        Node<T> parent;
        Node<T> leftChild;
        Node<T> rightChild;
        T value;

        public Node() {
        }

        public Node(T value) {
            this.value = value;
        }
    }
}
