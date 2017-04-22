package week2.home4;

public class Magazine extends Edition {
    private Periodicity periodicity;

    public Magazine(String title, int year, Periodicity periodicity, int count) {
        super(title, year, count);
        this.periodicity = periodicity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Magazine magazine = (Magazine) o;

        return periodicity == magazine.periodicity;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (periodicity != null ? periodicity.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + ", periodicity=" + periodicity;
    }
}
