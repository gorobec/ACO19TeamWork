package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class MyLinkedList implements MyList {

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
    }

    private boolean addNodeToEmptyList(Object o) {
        Node newNode = new Node(o);

        if (isEmpty()) {
            head = tail = newNode;
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
    public boolean add(Object o) {

        Node newNode = new Node(o);

        if (addNodeToEmptyList(o)) return true;

        newNode.setPrev(tail);
        tail.setNext(newNode);
        tail = newNode;
        size++;

        return true;
    }

    @Override
    public boolean add(Object o, int index) {

        if (index == 0) return addFirst(o);
        if (index == size - 1) return addLast(o);

        if (!checkIndex(index)) return false;

        Node newNode = new Node(o);
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
    public boolean addFirst(Object o) {

        if (addNodeToEmptyList(o)) return true;

        Node newNode = new Node(o);
        Node nextNode = head;

        head = newNode;

        head.setNext(nextNode);
        nextNode.setPrev(head);
        size++;

        return true;
    }

    @Override
    public boolean addLast(Object o) {

        if (addNodeToEmptyList(o)) return true;

        Node newNode = new Node(o);
        Node prevNode = tail;

        tail = newNode;

        prevNode.setNext(tail);
        tail.setPrev(prevNode);
        size++;

        return true;
    }

    @Override
    public Node get(int index) {
        if (!checkIndex(index)) return null;

        Node currNode = head;
        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        return currNode;
    }

    @Override
    public boolean remove(int index) {

        if (isEmpty() || checkIndex(index)) return false;

        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();

        Node deletingNode = head;

        for (int i = 0; i < index; i++) {
            deletingNode = deletingNode.getNext();
        }

        Node prevNode = deletingNode.getPrev();
        Node nextNode = deletingNode.getNext();

        prevNode.setNext(nextNode);
        nextNode.setPrev(prevNode);

        deletingNode = null;
        size--;

        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (isEmpty() || !contains(o)) return false;

        Node currNode = head;

        for (int i = 0; i < size; i++) {
            currNode = currNode.getNext();

            if ((o == null && currNode.getData() == null)
                    || o.equals(currNode.getData())) return remove(i);
        }

        return true;
    }

    @Override
    public boolean removeLast() {

        if (isEmpty()) return false;

        Node prevNode = tail.getPrev();

        tail = null;
        tail = prevNode;

        size--;

        return true;
    }

    @Override
    public boolean removeFirst() {

        if (isEmpty()) return false;

        Node nextNode = head.getNext();

        head = null;
        head = nextNode;

        size--;

        return true;
    }

    // метод set() в моем понимании - это просто замена объекта в ноде, не меняя саму ноду
    // (???)
    @Override
    public Object set(int index, Object o) {

        if (isEmpty() || !checkIndex(index)) return false;

        Node currNode = head;

        for (int i = 0; i < index; i++) {
            currNode = currNode.getNext();
        }

        currNode.setData(o);
        return true;
    }

    @Override
    public void clear() {

        Node tmp = head;

        while (tmp.getNext() != null) {
            tmp = tmp.getNext();
            head = null;
            head = tmp;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {

        Node currNode = head;

        for (int i = 0; i < size; i++) {

            currNode = currNode.getNext();
            if (o == null && currNode.getData() == null || currNode.getData().equals(o)) return true;
        }
        return false;
    }

    // ********* NESTED CLASS NODE ***********
    public static class Node {

        private Object data;
        private Node next;
        private Node prev;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next, Node prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
