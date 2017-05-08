package week2.interfaces.booksInterfaces;

/**
 * Created by SmooZzzie on 22.04.2017.
 */
public abstract class Book {

    private String name;
    private int quantityOfPages;
    private String typeOfBook;
    private int lastReadPage;



    public Book(String name, int quantityOfPages, String typeOfBook, int lastReadPage) {
        this.name = name;
        this.quantityOfPages = quantityOfPages;
        this.typeOfBook = typeOfBook;
        this.lastReadPage = lastReadPage;
    }

    // own method of abstract class Book
    public boolean read() {

        if (lastReadPage < quantityOfPages){
            for (int i = 0; lastReadPage < quantityOfPages ; i++) {
                lastReadPage++;
            }
        }

        if (lastReadPage == quantityOfPages) {
            System.out.println("The book is already read!");
            return true;
        }

        return false;
    }

    //abstract method buy() which should be overrode
    public abstract boolean buy();


}
