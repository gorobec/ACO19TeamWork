package homeWorkWeek3.LinkedList;

/**
 * Created by volodymyrkorniienko on 01.05.17.
 */
public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public boolean add(T o) {
        if (head == null) {
            head = tail = new Node<>(o);
            size++;
            return true;
        }
        Node<T> newNode = new Node<>(tail, o);
        tail.setNext(newNode);
        tail = newNode;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, T o) {
        Node<T> newNode = new Node<>(o);
        Node<T> temp = head;

        if (index < 0 || index > size) {
            return false;
        }
        if (temp != null) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        newNode.setNext(temp);
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        if (index > size || index < 0) {
            System.err.print("IndexOutOfBound!");
            return null;
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.getValue();
    }

    @Override
    public boolean remove(int index) {
        if (index > size || index < 0) {
            System.err.println("IndexOutOfBound!");
        }

        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.getNext() == null) {
                return false;
            }
            temp = temp.next;
        }
        temp.setNext(temp.next.next);
        size--;
        return false;
    }

    @Override
    public boolean remove(T o) {
        Node<T> previous = null;
        Node<T> current = head;

        if (o == null) {
            return false;
        }

        while (current != null) {
            if (current.getValue().equals(o)) {
                current = current.next;
                if (previous == null) {
                    previous = current;
                    size--;
                    return true;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
        return false;
    }

    @Override
    public void set(int index, T o) {
        if (o == null) {
            return;
        }
        Node<T> current = goTo(index);
        current.setValue(o);
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.getValue().equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<T> goTo(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private static class Node<T> {

        private Node<T> next;
        private Node<T> previous;
        private T value;

        public Node() {
        }

        Node(T value) {
            this.value = value;
        }

        Node(Node<T> previous, T value) {
            this.previous = previous;
            this.value = value;
        }

        Node getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        T getValue() {
            return value;
        }

        void setValue(T value) {
            this.value = value;
        }
    }
}






