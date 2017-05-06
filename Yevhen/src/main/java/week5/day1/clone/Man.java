package week5.day1.clone;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Man extends Person{

    private Woman wife;

    public Man(String name, int age, Woman wife) {
        super(name, age);
        this.wife = wife;
    }

    public Man(Man man) {
        super(man.name, man.age);
        this.wife = new Woman(man.wife);
    }




    public Woman getWife() {
        return wife;
    }

    public void setWife(Woman wife) {
        this.wife = wife;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Man man = (Man) o;

        return wife != null ? wife.equals(man.wife) : man.wife == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (wife != null ? wife.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Man{");
        sb.append(super.toString());
        sb.append("wife=").append(wife);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected Man clone() throws CloneNotSupportedException {
        Man clone = (Man) super.clone();
        clone.setWife(this.wife.clone());
        return clone;

    }
}
