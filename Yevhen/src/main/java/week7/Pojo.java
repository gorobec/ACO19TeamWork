package week7;

/**
 * Created by gorobec on 20.05.17.
 */
public class Pojo {
    private String name;
    private int age;
    private boolean isHappy;
    private float salary;


    public Pojo(String name, int age, boolean isHappy, float salary) {
        this.name = name;
        this.age = age;
        this.isHappy = isHappy;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pojo pojo = (Pojo) o;

        if (age != pojo.age) return false;
        if (isHappy != pojo.isHappy) return false;
        if (Float.compare(pojo.salary, salary) != 0) return false;
        return name != null ? name.equals(pojo.name) : pojo.name == null;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (isHappy ? 1 : 0);
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        return result;
    }
}
