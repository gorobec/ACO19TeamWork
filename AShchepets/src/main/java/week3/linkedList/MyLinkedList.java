package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList<T> implements MyList<T> {

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

        newNode.prev = tail;
        tail.next = newNode;
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
    public boolean addFirst(T o) {

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
    public boolean addLast(T o) {

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
    public T get(int index) {
        if (!checkIndex(index)) return null;

        Node<T> currNode = findNode(index);

        return currNode.data;
    }

    @Override
    public boolean remove(int index) {

        if (isEmpty() || !checkIndex(index)) return false;

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

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
    public boolean removeLast() {

        if (isEmpty()) return false;

        Node<T> prevNode = tail.prev;

        tail = null;
        tail = prevNode;

        size--;

        return true;
    }

    @Override
    public boolean removeFirst() {

        if (isEmpty()) return false;

        Node<T> nextNode = head.next;

        head = null;
        head = nextNode;

        size--;

        return true;
    }

    @Override
    public T set(int index, T o) {

        if (isEmpty() || !checkIndex(index)) return null;

        Node<T> currNode = findNode(index);

        T oldObject =  currNode.data;
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
}
