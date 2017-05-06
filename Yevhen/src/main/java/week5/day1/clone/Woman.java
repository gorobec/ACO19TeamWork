package week5.day1.clone;

/**
 * @author Yevhen Vorobiei
 * @since JDK 1.8
 */
public class Woman extends Person{
    private Child child;

    public Woman(String name, int age, Child child) {
        super(name, age);
        this.child = child;
    }

    public Woman(Woman wife) {
        super(wife.name, wife.age);
        this.child = new Child(wife.getChild());
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Woman woman = (Woman) o;

        if (child != null ? !child.equals(woman.child) : woman.child != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (child != null ? child.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Woman{");
        sb.append(super.toString());
        sb.append("child=").append(child);
        sb.append('}');
        return sb.toString();
    }

    @Override
    protected Woman clone() throws CloneNotSupportedException {
        Woman clone = (Woman) super.clone();
        clone.setChild(this.child.clone());
        return clone;
    }
}
