package data_structures;

import java.util.Iterator;

/**
 * Created by gorobec on 22.04.17.
 */
public class MyLinkedList<T> implements MyList<T>{

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
    }

    @Override
    public boolean add(Object o) {
        if(head == null){
            head = tail = new Node(o);
        } else {
            Node newNode = new Node(null, tail, o);
            tail.next = newNode;
            tail = newNode;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object o, int index) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T remove(int index) {

        Node<T> forRemove = findNode(index);
//        TODO with exception
        if(forRemove == null) return null;


        if(forRemove == head){
            head = forRemove.next;
        } else {
            forRemove.previous.next = forRemove.next;
        }
        if (forRemove == tail){
            tail = forRemove.previous;
        } else {
            forRemove.next.previous = forRemove.previous;
        }
        forRemove.next = null;
        forRemove.previous = null;
        size--;
        return forRemove.value;
    }

    private Node findNode(int index) {
        if(checkIndex(index)){
//            find Node

            Node iterator = head;

            for (int i = 0; i < index; i++) {
                iterator = iterator.next;
            }
            return iterator;
        }
//        System.exit(-1);
        return null;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean set(Object o, int index) {
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    public static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private T value;

        public Node(T value) {
            this.value = value;
        }

        public Node(Node<T> next, Node<T> previous, T value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }

    private class MyLinkedListIterator implements Iterator<T> {


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
