package week2.home2;

public class Catalog extends Book {

    public Catalog(int year, int pages) {
        super(year, pages);
    }

    @Override
    public String read() {
        return "The Catalog is very informative issue.";
    }
}
