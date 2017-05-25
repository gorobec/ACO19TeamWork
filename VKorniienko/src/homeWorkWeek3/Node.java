package homeWorkWeek3;

/**
 * Created by volodymyrkorniienko on 24.04.17.
 */
public class Node {

    private Node next;
    private Node previous;
    private Object value;

    public Node() {
    }

    public Node(Object value) {
        this.value = value;
    }

    public Node(Node next, Node previous, Object value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
