package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList<T> implements MyList {

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

    private boolean addNodeToEmptyList(T o) {

        if (isEmpty()) {
            Node<T> newNode = new Node<>(o);

            head = tail = newNode;
            size++;

            return true;
        } else return false;
    }

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

        Node<T> newNode = new Node<>(o);

        if (addNodeToEmptyList(o)) return true;

        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean add(T o, int index) {

        if (index == 0) return addFirst(o);
        if (index == size - 1) return addLast(o);

        if (!checkIndex(index)) return false;

        Node<T> newNode = new Node<>(o);
        Node currNode = head;

        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        Node prevNode = currNode.getPrev();

        // привязываемся К новому элементу
        currNode.setPrev(newNode);
        prevNode.setNext(newNode);

        // привязываем новый элемент к соседним
        newNode.setNext(currNode);
        newNode.setPrev(prevNode);

        size++;

        return true;
    }

    @Override
    public boolean addFirst(T o) {

        if (addNodeToEmptyList(o)) return true;

        Node<T> newNode = new Node<>(o);
        Node<T> nextNode = head;

        head = newNode;

        head.setNext(nextNode);
        nextNode.setPrev(head);
        size++;

        return true;
    }

    @Override
    public boolean addLast(T o) {

        if (addNodeToEmptyList(o)) return true;

        Node<T> newNode = new Node<>(o);
        Node<T> prevNode = tail;

        tail = newNode;

        prevNode.setNext(tail);
        tail.setPrev(prevNode);
        size++;

        return true;
    }

    @Override
    public T get(int index) {
        if (!checkIndex(index)) return null;

        Node<T> currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        return (T) currNode.getData();
    }

    @Override
    public boolean remove(int index) {

        if (isEmpty() || !checkIndex(index)) return false;

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node<T> deletingNode = head;

        for (int i = 0; i < index; i++) {
            deletingNode = deletingNode.getNext();
        }

        Node<T> prevNode = deletingNode.getPrev();
        Node<T> nextNode = deletingNode.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

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

                if (o == null && currNode.getData() == null) return remove(i);
                currNode = currNode.getNext();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(currNode.getData())) return remove(i);
                currNode = currNode.getNext();
            }
        }


        return true;
    }

    @Override
    public boolean removeLast() {

        if (isEmpty()) return false;

        Node<T> prevNode = tail.getPrev();

        tail = null;
        tail = prevNode;

        size--;

        return true;
    }

    @Override
    public boolean removeFirst() {

        if (isEmpty()) return false;

        Node<T> nextNode = head.getNext();

        head = null;
        head = nextNode;

        size--;

        return true;
    }

    // метод set() в моем понимании - это просто замена data в ноде, не меняя саму ноду
    // (???)
    @Override
    public T set(int index, T o) {

        if (isEmpty() || !checkIndex(index)) return null;

        Node<T> currNode = head;

        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        T oldObject = (T)currNode.getData();
        currNode.setData(o);
        return oldObject;
    }

    @Override
    public void clear() {

        Node<T> tmp = head;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
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
                if (currNode.getData() == null) return true;
                currNode = currNode.getNext();
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (currNode.getData().equals(o)) return true;
                currNode = currNode.getNext();
            }
        }
        return false;
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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }
}
