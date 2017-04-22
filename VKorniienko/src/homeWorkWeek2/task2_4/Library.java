package homeWorkWeek2.task2_4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volodymyrkorniienko on 17.04.17.
 */
public class Library{

    private static final int COUNT_OF_READERS = 100;
    private static final int COUNT_OF_BOOKS = 1000;

    private List<Reader> readers = new ArrayList<>(COUNT_OF_READERS);
    private List<Book> books = new ArrayList<>(COUNT_OF_BOOKS);

    public boolean addReaderToLibrary(Reader reader) {
        readers.add(reader);
        return true;
    }

    public boolean showListOfReaders() {
        if (readers.size() == 0) {
            System.out.println("Sorry. No readers!!!");
            return false;
        }
        for (int i = 0; i < readers.size(); i++) {
            System.out.println(readers.get(i).toString());
        }
        return true;
    }

    public boolean addBookToLibrary(Book book) {
        books.add(book);
        return true;
    }

    public boolean showListOfBooks() {
        if (books.size() == 0) {
            System.out.println("Sorry. No books!!!");
            return false;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i).toString());
        }
        return true;
    }

//    public void listOfBooksOnReaders() {
//        for (int i = 0; i < readers.size(); i++) {
//            if(!readers.get(i).getBooks().get(i).equals(0)) {
//                for (int j = 0; j < books.size(); j++) {
//                    books.get(j).toString();
//                }
//            }
//        }
//    }

    public void listOfReaderBooks(Reader reader) {
        for (int i = 0; i < readers.size(); i++) {
            if(readers.get(i).equals(reader)) {
                reader.listOfBooks();
            }
        }
    }
}
