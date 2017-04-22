package homeWorkWeek2.task2_2.interfaceEdition;

/**
 * Created by volodymyrkorniienko on 11.04.17.
 */
public class Handbook extends Book implements Edition {

    private String bookName = "Abstractions and interface";
    private String editionName = "HomeWorkOOP";
    private String autor = "Test";
    private int countOfBooks = 5;
    private int publishYear = 1991;
    private String bookType = "Handbook";

    @Override
    public String getEditionName() {
        return this.editionName;
    }

    @Override
    public int publishYear() {
        return this.publishYear;
    }

    @Override
    public String bookType() {
        return this.bookType;
    }

    @Override
    public boolean buy() {
        if (countOfBooks == 0) {
            System.out.println("Book absent");
            return false;
        }
        if (countOfBooks > 0) {
            System.out.println("You buy book!");
            countOfBooks--;
        }
        return true;
    }

    @Override
    public String getBookName() {
        return this.bookName;
    }

    @Override
    public String getBookAutor() {
        return this.autor;
    }
}
