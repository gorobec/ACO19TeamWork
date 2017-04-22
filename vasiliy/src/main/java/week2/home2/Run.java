package week2.home2;

public class Run {
    public static void main(String[] args) {
        Doctor surgeon = new Surgeon();
        Doctor neurosurgeon = new Neurosurgeon();

        System.out.println(surgeon.work());
        System.out.println(neurosurgeon.work());

        Book catalog = new Catalog(2017, 135);
        Book encyclopedia = new Encyclopedia(2015, 700);

        System.out.println(String.format("%s %s", catalog.read(), catalog));
        System.out.println(String.format("%s %s", encyclopedia.read(), encyclopedia));
    }
}
