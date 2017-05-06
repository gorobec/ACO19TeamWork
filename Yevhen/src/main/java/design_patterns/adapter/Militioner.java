package design_patterns.adapter;

import week5.day1.clone.Person;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Militioner extends Person implements ILaw{

    public Militioner(String name, int age) {
        super(name, age);
    }


    @Override
    public void makeLaw() {
        System.out.println("Take brides");
    }
}
