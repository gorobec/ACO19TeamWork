package homeWorkWeek2.task2_9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyrkorniienko on 17.04.17.
 */
public class Cat {

    public static Cat cat = new Cat();
    public static List<Cat> cats = new ArrayList<>();

    private String name;
    private String sex;
    private int age;

    public Cat() {
    }

    public Cat createCat(String name, String sex, int age) {
        cat.setName(name);
        cat.setSex(sex);
        cat.setAge(age);
        return cat;
    }

    public void addCat(Cat cat) {
        cats.add(cat);
    }

    public Cat(String name, String sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        Cat cat = createCat(name, sex, age);
        addCat(cat);
    }

    public static void printCat() {
        for (int i = 0; i < cats.size(); i++) {
            System.out.println(cats.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Cat" + " " +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
