package data_structures.single_linked_list;

public class Run {
    public static void main(String[] args) {
        Node<String> head = (Node<String>) ListUtils.createStringList();
        head.showList();
        head = (Node<String>) ListUtils.reversion(head);
        head.showList();
    }
}
