package data_structures;

import java.util.Iterator;

public class MyLinkedList implements MyList {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(Object[] array) {
        for (Object obj : array) {
            this.add(obj);
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if (isEmpty()) {
            head = new Node(o);
            tail = head;
        } else {
            Node node = new Node(o, null, tail);
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return checkIndex(indexOf(o));
    }

    @Override
    public boolean add(int index, Object o) {
        if (!checkIndex(index)) {
            return false;
        }
        Node objectNode = new Node(o);
        Node node;
        if (index == size - 1) {
            node = tail;
        } else {
            node = findNode(index);
        }
        node.previous = objectNode;
        objectNode.next = node;
        if (index != 0) {
            objectNode.previous = node.previous;
            node.previous.next = objectNode;
        } else {
            head = objectNode;
        }
        size++;
        return true;
    }

    private Node findNode(int index) {
        if (index < size / 2) {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            Node currentNode = tail;
            for (int i = 0; i < size - 1 - index; i++) {
                currentNode = currentNode.previous;
            }
            return currentNode;
        }
    }

    @Override
    public Object get(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        return findNode(index).value;
    }

    private void removeNode(Node node) {
        if (size == 1) {
            clear();
            return;
        }
        if (node == head) {
            node.next.previous = null;
            head = node.next;
            node.next = null;
            size--;
            return;
        }
        if (node == tail) {
            node.previous.next = null;
            tail = node.previous;
            node.previous = null;
            size--;
            return;
        }
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = null;
        node.previous = null;
        size--;
    }

    @Override
    public Object remove(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        Node node = findNode(index);
        removeNode(node);
        return node.value;
    }

    private Node findNode(Object o) {
        if (isEmpty()) {
            return null;
        }
        if (o == null) {
            Node node = head;
            do {
                if (node.value == null) {
                    return node;
                }
                node = node.next;
            } while (node != null);
        } else {
            Node node = head;
            do {
                if (o.equals(node.value)) {
                    return node;
                }
                node = node.next;
            } while (node != null);
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {
        Node node = findNode(o);
        if (node == null) {
            return false;
        }
        removeNode(node);
        return true;
    }

    @Override
    public Object set(int index, Object o) {
        if (!checkIndex(index)) {
            return null;
        }
        Node node = findNode(index);
        Object oldValue = node.value;
        node.value = o;
        return oldValue;
    }

    @Override
    public int indexOf(Object o) {
        if (isEmpty()) {
            return -1;
        }
        if (o == null) {
            Node node = head;
            int index = 0;
            do {
                if (node.value == null) {
                    return index;
                }
                index++;
                node = node.next;
            } while (node != null);
        } else {
            Node node = head;
            int index = 0;
            do {
                if (o.equals(node.value)) {
                    return index;
                }
                index++;
                node = node.next;
            } while (node != null);
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new MyLinkedListIterator();
    }

    private static class Node {
        private Object value;
        private Node next;
        private Node previous;

        public Node(Object value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(Object value) {
            this.value = value;
        }
    }

    private class MyLinkedListIterator implements Iterator {
        Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Object next() {
            Object value = current.value;
            current = current.next;
            return value;
        }
    }
}
