package data_structures;

public class MyLinkedList implements MyList {
    private Node head;
    private Node tail;
    private int size;

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
            tail.setNext(node);
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
        node.setPrevious(objectNode);
        objectNode.setNext(node);
        if (index != 0) {
            objectNode.setPrevious(node.getPrevious());
            node.getPrevious().setNext(objectNode);
        } else {
            head = objectNode;
        }
        size++;
        return true;
    }

    private Node findNode(int index) {
        if (index == size - 1) {
            return tail;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    @Override
    public Object get(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        return findNode(index).getValue();
    }

    private void removeNode(Node node) {
        if (size == 1) {
            clear();
            return;
        }
        if (node == head) {
            node.getNext().setPrevious(null);
            head = node.getNext();
            node.setNext(null);
            return;
        }
        if (node == tail) {
            node.getPrevious().setNext(null);
            tail = node.getPrevious();
            node.setPrevious(null);
            return;
        }
        node.getPrevious().setNext(node.getNext());
        node.getNext().setPrevious(node.getPrevious());
        node.setNext(null);
        node.setPrevious(null);
        size--;
    }

    @Override
    public Object remove(int index) {
        if (!checkIndex(index)) {
            return null;
        }
        Node node = findNode(index);
        removeNode(node);
        return node.getValue();
    }

    private Node findNode(Object o) {
        if (isEmpty()) {
            return null;
        }
        if (o == null) {
            Node node = head;
            do {
                if (node.getValue() == null) {
                    return node;
                }
                node = node.getNext();
            } while (node != null);
        } else {
            Node node = head;
            do {
                if (o.equals(node.getValue())) {
                    return node;
                }
                node = node.getNext();
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
        Object oldValue = node.getValue();
        node.setValue(o);
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
                if (node.getValue() == null) {
                    return index;
                }
                index++;
                node = node.getNext();
            } while (node != null);
        } else {
            Node node = head;
            int index = 0;
            do {
                if (o.equals(node.getValue())) {
                    return index;
                }
                index++;
                node = node.getNext();
            } while (node != null);
        }
        return -1;
    }
}
