package data_structures;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {

    }

    public MyLinkedList(T[] array) {
        for (T obj : array) {
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
    public boolean add(T o) {
        if (isEmpty()) {
            head = new Node<>(o);
            tail = head;
        } else {
            Node<T> node = new Node<>(o, null, tail);
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
    public boolean contains(T o) {
        return checkIndex(indexOf(o));
    }

    @Override
    public boolean add(int index, T o) {
        if (!checkIndex(index)) {
            return false;
        }
        Node<T> objectNode = new Node<>(o);
        Node<T> node;
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

    private Node<T> findNode(int index) {
        if (index < size / 2) {
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode;
        } else {
            Node<T> currentNode = tail;
            for (int i = 0; i < size - 1 - index; i++) {
                currentNode = currentNode.previous;
            }
            return currentNode;
        }
    }

    @Override
    public T get(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        return findNode(index).value;
    }

    private void removeNode(Node<T> node) {
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
    public T remove(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        Node<T> node = findNode(index);
        removeNode(node);
        return node.value;
    }

    private Node<T> findNode(T o) {
        if (isEmpty()) {
            return null;
        }
        if (o == null) {
            Node<T> node = head;
            do {
                if (node.value == null) {
                    return node;
                }
                node = node.next;
            } while (node != null);
        } else {
            Node<T> node = head;
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
    public boolean remove(T o) {
        Node<T> node = findNode(o);
        if (node == null) {
            return false;
        }
        removeNode(node);
        return true;
    }

    @Override
    public T set(int index, T o) {
        if (!checkIndex(index)) {
            return null;
        }
        Node<T> node = findNode(index);
        T oldValue = node.value;
        node.value = o;
        return oldValue;
    }

    @Override
    public int indexOf(T o) {
        if (isEmpty()) {
            return -1;
        }
        if (o == null) {
            Node<T> node = head;
            int index = 0;
            do {
                if (node.value == null) {
                    return index;
                }
                index++;
                node = node.next;
            } while (node != null);
        } else {
            Node<T> node = head;
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
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value) {
            this.value = value;
        }
    }

    private class MyLinkedListIterator implements Iterator<T> {
        Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            return value;
        }
    }
}
