package week3.day1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gorobec on 22.04.17.
 */
public class Cat {
    public static List<Cat> cats = new ArrayList<>();

    private String name;
    private String sex;
    private int age;

    public Cat(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        cats.add(this);
    }

    public static void printCat() {
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i));
        }
    }

    @Override
    public String toString() {
        return "Cat" + " " +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age;
    }
}
