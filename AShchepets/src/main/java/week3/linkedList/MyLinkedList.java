package week3.linkedList;

import week3.linkedList.interfaces.MyDeque;
import week3.linkedList.interfaces.MyList;

import java.util.NoSuchElementException;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList<T> implements MyList<T>, MyDeque<T> {

    private Node<T> head;
    private Node<T> tail;

    // аля очень большое (типа неограничение количество)
    // ограничивать будет пользователь при создании конструктора с размером
    private int maxSize = 1000000;
    private int size;

    public MyLinkedList() {
    }

    public MyLinkedList(T[] array) {
        for (int i = 0; i < array.length; i++) {
            this.add(array[i]);
        }
    }

    // constructor with restricted size
    public MyLinkedList(int maxSize) {
        this.maxSize = maxSize;
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
            return String.valueOf(data);
        }
    }

    private boolean addNodeToEmptyList(T o) {

        Node<T> newNode = new Node<>(o);

        head = tail = newNode;
        size++;

        return true;
    }

    private Node<T> findNode(int index) {
        checkIndex(index);
        Node<T> currNode;
        if (index < size / 2) {
            currNode = head;
            for (int i = 0; i < index; i++) {
                currNode = currNode.next;
            }
        } else {
            currNode = tail;
            for (int i = 0; i < size - index - 1; i++) {
                currNode = currNode.prev;
            }
        }
        return currNode;
    }


    //*************METHODS FROM MYCOLLECTION AND MYLIST**************
    @Override
    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException(String.format("Index: %s", index));
    }

    @Override
    public boolean add(T o) {

        if (size >= maxSize) throw new IllegalStateException("Your deque is restricted and already filled!");

        Node<T> newNode = new Node<>(o);

        if (isEmpty()) return addNodeToEmptyList(o);

        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean add(T o, int index) {

        if (size >= maxSize) {
            throw new IllegalStateException("Your deque already filled!");
        }

        checkIndex(index);

        if (index == 0) {
            addFirst(o);
            return true;
        }
        if (index == size - 1) {
            addLast(o);
            return true;
        }

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

        Node<T> currNode = findNode(index);

        return currNode.data;
    }

    @Override
    public boolean remove(int index) {

        checkIndex(index);

        if (isEmpty()) return false;

        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }

        Node<T> deletingNode = findNode(index);

        deleteNode(deletingNode);

        size--;

        return true;
    }

    private void deleteNode(Node<T> deletingNode) {
        Node<T> prevNode = deletingNode.prev;
        Node<T> nextNode = deletingNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    @Override
    public boolean remove(T o) {

        if (isEmpty()) return false;

        Node<T> deletingNode = findNode(o);

        deleteNode(deletingNode);

        size--;

        return true;
    }


    @Override
    public T set(int index, T o) {

        if (isEmpty()) return null;

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
        return findNode(o) != null;
    }

    private Node<T> findNode(Object o) {

        Node<T> currNode = head;

        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (currNode.data == null) return currNode;
                currNode = currNode.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (currNode.data.equals(o)) return currNode;
                currNode = currNode.next;
            }
        }
        return null;
    }

    // **********ADDED METHODS FROM DEQUE INTERFACE**************

    @Override
    public void addFirst(T o) {

        if (size >= maxSize) throw new IllegalStateException("Your deque is already filled!");

        if (isEmpty()) {
            addNodeToEmptyList(o);
            return;
        }

        addFirstNode(o);
        size++;

    }

    @Override
    public void addLast(T o) {

        if (size >= maxSize) throw new IllegalStateException("Your deque is already filled!");

        if (isEmpty()) {
            addNodeToEmptyList(o);
            return;
        }


        addLastNode(o);
        size++;

    }

    private void addLastNode(T o) {
        Node<T> newNode = new Node<>(o);
        Node<T> prevNode = tail;

        tail = newNode;

        prevNode.next = tail;
        tail.prev = prevNode;
    }

    @Override
    public T removeFirst() {
        // Retrieves and removes the first element of this deque.
        // This method differs from pollFirst only in that it throws an exception if this deque is empty.
        if (isEmpty()) throw new NoSuchElementException("Deque is empty!");

        return deleteFirstNode();
    }

    @Override
    public T removeLast() {
        // Retrieves and removes the last element of this deque.
        // This method differs from pollLast only in that it throws an exception if this deque is empty.

        if (isEmpty()) throw new NoSuchElementException("Deque is empty!");

        return deleteLastNode();
    }

    @Override
    public T element() {
        //Retrieves, but does not remove, the head of the queue represented by this deque
        // (in other words, the first element of this deque).
        // This method differs from peek only in that it throws an exception if this deque is empty.
        //This method is equivalent to getFirst().
        return getFirst();
    }

    @Override
    public T getFirst() {
        //Retrieves, but does not remove, the first element of this deque.
        // This method differs from peekFirst only in that it throws an exception if this deque is empty.

        if (isEmpty()) throw new NoSuchElementException("Deque is empty!");

        return head.data;
    }

    @Override
    public T getLast() {
        //Retrieves, but does not remove, the last element of this deque.
        // This method differs from peekLast only in that it throws an exception if this deque is empty.

        if (isEmpty()) throw new NoSuchElementException("Deque is empty!");

        return tail.data;
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
        return offerLast(e);
    }

    @Override
    public boolean offerFirst(T e) {
        /*Inserts the specified element at the front of this deque unless it would violate capacity restrictions.
         When using a capacity-restricted deque, this method is generally preferable to the addFirst(E) method,
          which can fail to insert an element only by throwing an exception.*/

        if (size >= maxSize) return false;

        if (isEmpty()) return addNodeToEmptyList(e);


        addFirstNode(e);

        size++;

        return true;
    }

    private void addFirstNode(T e) {
        Node<T> newNode = new Node<>(e);
        Node<T> nextNode = head;

        head = newNode;

        head.next = nextNode;
        nextNode.prev = head;
    }

    @Override
    public boolean offerLast(T e) {
        /*Inserts the specified element at the end of this deque unless it would violate capacity restrictions.
         When using a capacity-restricted deque,
          this method is generally preferable to the addLast(E) method,
           which can fail to insert an element only by throwing an exception.*/

        if (isEmpty()) return addNodeToEmptyList(e);

        if (size >= maxSize) return false;

        addLastNode(e);
        size++;

        return true;
    }

    @Override
    public T peek() {
        // Retrieves, but does not remove, the head of the queue represented by this deque
        // (in other words, the first element of this deque), or returns null if this deque is empty.
        //This method is equivalent to peekFirst().

        return peekFirst();
    }

    @Override
    public T peekFirst() {
        // Retrieves, but does not remove, the first element of this deque, or returns null if this deque is empty.
        if (isEmpty()) return null;

        return head.data;
    }

    @Override
    public T peekLast() {
        //Retrieves, but does not remove, the last element of this deque, or returns null if this deque is empty.
        if (isEmpty()) return null;

        return tail.data;
    }

    @Override
    public T poll() {
    /*    Retrieves and removes the head of the queue represented by this deque
        (in other words, the first element of this deque),
        or returns null if this deque is empty.
        This method is equivalent to pollFirst().*/

        return pollFirst();
    }

    @Override
    public T pollFirst() {
        //Retrieves and removes the first element of this deque, or returns null if this deque is empty.
        if (isEmpty()) return null;

        return deleteFirstNode();
    }

    private T deleteFirstNode() {
        Node<T> nextNode = head.next;
        T data = head.data;

        head = nextNode;

        size--;
        return data;
    }

    @Override
    public T pollLast() {
        //Retrieves and removes the last element of this deque, or returns null if this deque is empty.
        if (isEmpty()) return null;

        return deleteLastNode();
    }

    private T deleteLastNode() {
        Node<T> prevNode = tail.prev;
        T data = tail.data;
        tail = prevNode;

        size--;
        return data;
    }

    @Override
    public T remove() {

        // Retrieves and removes the head of the queue represented by this deque
        // (in other words, the first element of this deque).
        // This method differs from poll only in that it throws an exception if this deque is empty.
        //This method is equivalent to removeFirst().
        return removeFirst();
    }

    @Override
    public void push(T e) {
        // Pushes an element onto the stack represented by this deque (in other words, at the head of this deque)
        // if it is possible to do so immediately without violating capacity restrictions,
        // throwing an IllegalStateException if no space is currently available.
        addFirst(e);
    }
}
