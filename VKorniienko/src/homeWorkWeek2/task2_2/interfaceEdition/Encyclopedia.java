package homeWorkWeek2.task2_2.interfaceEdition;

/**
 * Created by volodymyrkorniienko on 11.04.17.
 */
public class Encyclopedia extends Book implements Edition {

    private String bookName = "Abstractions and interface";
    private String editionName = "HomeWorkOOP";
    private String autor = "Test";
    private int countOfBooks = 5;
    private int publishYear = 1992;
    private String bookType = "Encyclopedia";

    public String getEditionName() {
        return this.editionName;
    }

    public int publishYear() {
        return this.publishYear;
    }

    public String bookType() {
        return this.bookType;
    }

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

    public String getBookName() {
        return this.bookName;
    }

    public String getBookAutor() {
        return this.autor;
    }
}