package week5.day1.clone;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class TestClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Child child = new Child("Artur", 15);
        Woman wife = new Woman("Alice", 35, child);
        Man man = new Man("John", 40, wife);

        System.out.println(man);

        Man clone = man.clone();
        System.out.println(clone);

        man.setAge(46);

        System.out.println("***** After man grown up ********");
        System.out.println(man);
        System.out.println(clone);
        man.getWife().setAge(37);

        System.out.println("***** After wife grown up ********");
        System.out.println(man);
        System.out.println(clone);

        man.getWife().getChild().setAge(17);

        System.out.println("***** After child grown up ********");
        System.out.println(man);
        System.out.println(clone);
    }
}
