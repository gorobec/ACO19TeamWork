package week5.day1.clone;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Child extends Person{
    public Child(String name, int age) {
        super(name, age);
    }

    public Child(Child child) {
        super(child.name, child.age);
    }

    @Override
    protected Child clone() throws CloneNotSupportedException {
        return (Child)super.clone();
    }
}
