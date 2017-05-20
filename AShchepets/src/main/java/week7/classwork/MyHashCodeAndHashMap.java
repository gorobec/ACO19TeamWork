package week7.classwork;

/**
 * Created by SmooZzzie on 20.05.2017.
 */
public class MyHashCodeAndHashMap {

   private String name;
   private int age;
   private boolean isHappy;
   private float salary;

    public MyHashCodeAndHashMap(String name, int age, boolean isHappy, float salary) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyHashCodeAndHashMap that = (MyHashCodeAndHashMap) o;

        if (age != that.age) return false;
        if (isHappy != that.isHappy) return false;
        if (Float.compare(that.salary, salary) != 0) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        // for null start from simple number result
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (isHappy ? 1 : 0);
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        return result;
    }
}
