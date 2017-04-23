package data_structures;

public class Run {
    public static void main(String[] args) {
        MyList myList = new MyLinkedList();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        for (Object obj : myList) {
            System.out.println(obj);
        }
    }
}
