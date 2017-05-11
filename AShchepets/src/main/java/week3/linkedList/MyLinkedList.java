package week3.linkedList;

import week3.linkedList.interfaces.MyDeque;
import week3.linkedList.interfaces.MyList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList<T> implements MyList<T>, MyDeque<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
    }

    public MyLinkedList(T[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    // ********* NESTED CLASS NODE ***********
    public static class Node<T> {

        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    private boolean addNodeToEmptyList(T o) {

        if (isEmpty()) {
            Node<T> newNode = new Node<>(o);

            head = tail = newNode;
            size++;

            return true;
        } else return false;
    }

    private Node<T> findNode(int index) {

        if (index < size / 2) {
            Node<T> currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
            return currNode;
        } else {
            Node<T> currNode = tail;
            for (int i = 0; i < size - index - 1; i++) {
                currNode = currNode.prev;
            }
            return currNode;
        }
    }

    //*************METHODS FROM MYCOLLECTION AND MYLIST**************
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public boolean add(T o) {
        //TODO Exception: throwing an IllegalStateException if no space is currently available.
        Node<T> newNode = new Node<>(o);

        if (addNodeToEmptyList(o)) return true;

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean add(T o, int index) {

        if (index == 0) {
            addFirst(o);
            return true;
        }
        if (index == size - 1) {
            addLast(o);
            return true;
        }

        if (!checkIndex(index)) return false;

        Node<T> newNode = new Node<>(o);

        Node<T> currNode = findNode(index);

        Node<T> prevNode = currNode.prev;

        // привязываемся К новому элементу
        currNode.prev = newNode;
        prevNode.next = newNode;

        // привязываем новый элемент к соседним
        newNode.next = currNode;
        newNode.prev = prevNode;

        size++;

        return true;
    }


    @Override
    public T get(int index) {
        if (!checkIndex(index)) return null;

        Node<T> currNode = findNode(index);

        return currNode.data;
    }

    @Override
    public boolean remove(int index) {

        if (isEmpty() || !checkIndex(index)) return false;

        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }

        Node<T> deletingNode = findNode(index);

        Node<T> prevNode = deletingNode.prev;
        Node<T> nextNode = deletingNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        deletingNode = null;
        size--;

        return true;
    }

    @Override
    public boolean remove(T o) {

        if (isEmpty() || !contains(o)) return false;

        Node<T> currNode = head;

        if (o == null) {
            for (int i = 0; i < size; i++) {

                if (currNode.data == null) return remove(i);
                currNode = currNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(currNode.data)) return remove(i);
                currNode = currNode.next;
            }
        }


        return true;
    }


    @Override
    public T set(int index, T o) {

        if (isEmpty() || !checkIndex(index)) return null;

        Node<T> currNode = findNode(index);

        T oldObject = currNode.data;
        currNode.data = o;

        return oldObject;
    }

    @Override
    public void clear() {

        Node<T> tmp = head;

        while (tmp.next != null) {
            tmp = tmp.next;
            head = null;
            head = tmp;
        }

        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        Node<T> currNode = head;

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (currNode.data == null) return true;
                currNode = currNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (currNode.data.equals(o)) return true;
                currNode = currNode.next;
            }
        }
        return false;
    }

    // **********ADDED METHODS FROM DEQUE INTERFACE**************

    @Override
    public void addFirst(T o) {
        // TODO throwing an IllegalStateException if no space is currently available.
        if (addNodeToEmptyList(o)) return true;

        Node<T> newNode = new Node<>(o);
        Node<T> nextNode = head;

        head = newNode;

        head.next = nextNode;
        nextNode.prev = head;
        size++;

        return true;
    }

    @Override
    public void addLast(T o) {
        //TODO throwing an IllegalStateException if no space is currently available.
        if (addNodeToEmptyList(o)) return true;

        Node<T> newNode = new Node<>(o);
        Node<T> prevNode = tail;

        tail = newNode;

        prevNode.next = tail;
        tail.prev = prevNode;
        size++;

        return true;
    }

    @Override
    public T removeLast() {
        //TODO Retrieves and removes the last element of this deque.
        // TODO This method differs from pollLast only in that it throws an exception if this deque is empty.
        if (isEmpty()) return false;

        Node<T> prevNode = tail.prev;

        tail = null;
        tail = prevNode;

        size--;

        return true;
    }

    @Override
    public T removeFirst() {
        //TODO Retrieves and removes the first element of this deque.
        // TODO This method differs from pollFirst only in that it throws an exception if this deque is empty.
        if (isEmpty()) return false;

        Node<T> nextNode = head.next;

        head = null;
        head = nextNode;

        size--;

        return true;
    }

    @Override
    public T element() {
        //Retrieves, but does not remove, the head of the queue represented by this deque
        // (in other words, the first element of this deque).
        // This method differs from peek only in that it throws an exception if this deque is empty.
        //This method is equivalent to getFirst().
        return null;
    }

    @Override
    public T getFirst() {
        //Retrieves, but does not remove, the first element of this deque.
        // This method differs from peekLast only in that it throws an exception if this deque is empty.
        return null;
    }

    @Override
    public boolean offer(T e) {
       /* Inserts the specified element into the queue represented by this deque
                (in other words, at the tail of this deque)
        if it is possible to do so immediately without violating capacity restrictions,
        returning true upon success and false if no space is currently available.
                When using a capacity-restricted deque, this method is generally preferable to the add(E) method,
                which can fail to insert an element only by throwing an exception.
                This method is equivalent to offerLast(E).*/

        return false;
    }

    @Override
    public T getLast() {
        //Retrieves, but does not remove, the last element of this deque.
        // This method differs from peekLast only in that it throws an exception if this deque is empty.
        return null;
    }

    @Override
    public T peek() {
        // Retrieves, but does not remove, the head of the queue represented by this deque
        // (in other words, the first element of this deque), or returns null if this deque is empty.
        //This method is equivalent to peekFirst().
        return null;
    }

    @Override
    public T poll() {
    /*    Retrieves, but does not remove, the head of the queue represented by this deque
                (in other words, the first element of this deque).
        This method differs from peek only in that it throws an exception if this deque is empty.
                This method is equivalent to getFirst().*/

        return null;
    }

    @Override
    public boolean offerFirst(T e) {
        /*Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
         When using a capacity-restricted deque, this method is generally preferable to the addFirst(E) method,
          which can fail to insert an element only by throwing an exception.*/

        return false;
    }

    @Override
    public T remove() {

        // Retrieves and removes the head of the queue represented by this deque
        // (in other words, the first element of this deque).
        // This method differs from poll only in that it throws an exception if this deque is empty.
        //This method is equivalent to removeFirst().
        return null;
    }

    @Override
    public boolean offerLast(T e) {
        /*Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
         When using a capacity-restricted deque,
          this method is generally preferable to the addLast(E) method,
           which can fail to insert an element only by throwing an exception.*/

        return false;
    }

    @Override
    public T peekFirst() {
        // Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
        return null;
    }

    @Override
    public T peekLast() {
        //Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
        return null;
    }

    @Override
    public T pollFirst() {
        //Retrieves and removes the first element of this deque, or returns null if this deque is empty.
        return null;
    }

    @Override
    public T pollLast() {
        //Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        return null;
    }

    @Override
    public void push(T e) {
        // Pushes an element onto the stack represented by this deque (in other words, at the head of this deque)
        // if it is possible to do so immediately without violating capacity restrictions,
        // throwing an IllegalStateException if no space is currently available.
    }
}
