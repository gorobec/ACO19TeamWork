package week2.home2;

public abstract class Book implements Issue {
    private int year;
    private int pages;

    public Book(int year, int pages) {
        this.year = year;
        this.pages = pages;
    }

    public String toString() {
        return String.format("Year: %d, pages: %d", year, pages);
    }
}
