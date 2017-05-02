package homeWorkWeek3.LinkedList;

/**
 * Created by volodymyrkorniienko on 01.05.17.
 */
public class MyLinkedList implements MyList {

    private Node head;
    private Node tail;
    private int size;
    Node node = new Node();

    @Override
    public boolean add(Object o) {
        if (head == null) {
            head = tail = new Node(o);
            size++;
            return true;
        }
        Node newNode = new Node(tail, o);
        tail.setNext(newNode);
        tail = newNode;

        return true;
    }

    @Override
    public boolean add(int index, Object o) {
        Node newNode = new Node(o);
        Node temp = head;

        if (temp != null) {
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        newNode.setNext(temp);
        size++;
        return true;
    }

    @Override
    public Object get(int index) {
        if (index > size || index < 0) {
            System.err.print("IndexOutOfBound!");
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    @Override
    public boolean remove(int index) {
        if (index > size || index < 0) {
            System.err.println("IndexOutOfBound!");
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            if (temp.getNext() == null) {
                return false;
            }
            temp = temp.getNext();
        }
        temp.setNext(temp.getNext().getNext());
        size--;

        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            if (current.getValue().equals(o)) {
                current = current.getNext();
                if (previous == null) {
                    previous = current;
                    return true;
                } else {
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public void set(int index, Object o) {
        Node current = goTo(index);
        current.setValue(o);
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public boolean contains(Object o) {
        Node current = head;
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

    @Override
    public Node goTo(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current;
    }
}






