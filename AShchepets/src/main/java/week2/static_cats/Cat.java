package week2.static_cats;

import java.util.ArrayList;

/**
 * Created by SmooZzzie on 26.04.2017.
 */
public class Cat {

    public static ArrayList<Cat> cats = new ArrayList<>();

    private String name;
    private int age;


    public Cat(String name, int age) {

        this.name = name;
        this.age = age;

        cats.add(this);
    }

    public static void printCats() {

        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Cat " + name + " age: " + age;
    }
}
