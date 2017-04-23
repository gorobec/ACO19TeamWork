package data_structures;

import java.util.Iterator;

/**
 * Created by gorobec on 22.04.17.
 */
public class MyLinkedList implements MyList{

    private Node head;
    private Node tail;
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
    public Object get(int index) {
        return null;
    }

    @Override
    public Object remove(int index) {

        Node forRemove = findNode(index);
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
    public Iterator iterator() {
        return new MyLinkedListIterator();
    }

    public static class Node {
        private Node next;
        private Node previous;
        private Object value;

        public Node(Object value) {
            this.value = value;
        }

        public Node(Node next, Node previous, Object value) {
            this.next = next;
            this.previous = previous;
            this.value = value;
        }
    }

    private class MyLinkedListIterator implements Iterator {


        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
