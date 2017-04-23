package homeWorkWeek2.task2_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyrkorniienko on 19.04.17.
 */
public class Reader extends User {

    private int id;

    private static final int READER_COUNT_OF_BOOKS = 3;
    private static final int READER_IN_BLACKLIST = 100;

    private List<Book> books = new ArrayList<>(READER_COUNT_OF_BOOKS);
    private List<Reader> blackList = new ArrayList<>(READER_IN_BLACKLIST);

    public Reader(String name, String surname, String dateOfBirth) {
        super(name, surname, dateOfBirth);
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean readerGiveBooks(Reader reader, Book book) {
        for (int i = 0; i < blackList.size(); i++) {
            if (blackList.get(i).equals(reader)) {
                System.out.println("You in blacklist!!!");
                return false;
            }
        }
        if(books.size() < READER_COUNT_OF_BOOKS) {
                books.add(book);
                return true;
        }
        if(books.size() >= READER_COUNT_OF_BOOKS) {
            System.out.println("Sorry. You coudn't add this book: " + '\n'
                    + book.getName() + '\n'
                    + book.getAutor() + '\n'
                    + book.getPublicationDate());
            return false;
        }
        return true;
    }

    public void listOfBooks() {
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
    }

    public boolean addToBlackList(Reader reader) {
        blackList.add(reader);
        return true;
    }

    public String toString() {
        return "id: " + id + '\n' + super.toString();
    }
}
