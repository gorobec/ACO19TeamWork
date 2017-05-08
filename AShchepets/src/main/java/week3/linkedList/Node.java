package week3.linkedList;

/**
 * Created by SmooZzzie on 08.05.2017.
 */
public class Node {

    private Object data;
    private Object next;
    private Object prev;

    public Node(Object data) {
        this.data = data;
    }

    public Node(Object data, Object next, Object prev) {
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

    public Object getNext() {
        return next;
    }

    public void setNext(Object next) {
        this.next = next;
    }

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }
}
