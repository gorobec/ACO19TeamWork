package week3.singleListReversion;

public class ListUtils {


    public static A<String> createStringList() {
        A<String> head = new Node<>("A");
        A<String> second = new Node<>("B");
        A<String> third = new Node<>("C");
        A<String> fourth = new Node<>("D");
        A<String> fifth = new Node<>("E");
        A<String> sixth = new Node<>("F");
        A<String> seventh = new Node<>("G");
        head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        fourth.setNext(fifth);
        fifth.setNext(sixth);
        sixth.setNext(seventh);
        return head;
    }



    public static <T> A<T> reversion(A<T> head) {
//        todo write your code

        // дублирую кусок кода только ради последней строчки.
        // Нужно в первом элементе списка указатель на null поставить.
        // Кривовато написано :/

        A<T> prevEl = head;
        head = head.getNext();
        A<T> nextEl = head.getNext();
        head.setNext(prevEl);
        prevEl.setNext(null);

        while (nextEl != null) {
            prevEl = head;
            head = nextEl;
            nextEl = nextEl.getNext();
            head.setNext(prevEl);
        }

        return head;
    }
}
