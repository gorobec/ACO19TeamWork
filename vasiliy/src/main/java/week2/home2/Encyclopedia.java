package week2.home2;

public class Encyclopedia extends Book {

    public Encyclopedia(int year, int pages) {
        super(year, pages);
    }

    @Override
    public String read() {
        return "Encyclopedia is very interesting book.";
    }
}
