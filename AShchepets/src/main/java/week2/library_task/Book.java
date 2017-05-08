package week2.library_task;

/**
 * Created by SmooZzzie on 27.04.2017.
 */
public class Book extends Edition{

    private String author;
    private BookGenre genre;


    // constructor with default quantity
    public Book(String editionName, int yearOfPublishing, String author, BookGenre genre) {
        super(editionName, yearOfPublishing);
        this.author = author;
        this.genre = genre;
    }

    // constructor with preset quantity
    public Book(String editionName, int yearOfPublishing, int quantity, String author, BookGenre genre) {
        super(editionName, yearOfPublishing, quantity);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }
}
