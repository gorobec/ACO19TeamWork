package homeWorkWeek2.task2_4;

/**
 * Created by volodymyrkorniienko on 19.04.17.
 */
public class Book {

    private String name;
    private String autor;
    private int publicationDate;

    public Book() {
    }

    public Book(String name, String autor, int publicationDate) {
        this.name = name;
        this.autor = autor;
        this.publicationDate = publicationDate;
    }

    public String getName() {
        return name;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return "Book:" + "\n" +
                "Name: " + name + '\n' +
                "Auto: " + autor + '\n' +
                "Date of Publication: " + publicationDate + '\n';
    }
}
