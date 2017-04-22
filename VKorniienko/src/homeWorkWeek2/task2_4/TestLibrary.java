package homeWorkWeek2.task2_4;

/**
 * Created by volodymyrkorniienko on 20.04.17.
 */
public class TestLibrary {
    public static void main(String[] args) {

        Library library = new Library();

        Reader reader = new Reader("Vova", "Korniienko", "18.09.1991");
        library.addReaderToLibrary(reader);
        Reader reader1 = new Reader("Vova1", "Korniienko1", "18.09.1991");
        library.addReaderToLibrary(reader1);
//        library.showListOfReaders();

        Book book1 = new Book("Game of Thrones", "G. Matrin", 1998);
        Book book2 = new Book("Game of Thrones", "G. Matrin", 1992);
        library.addBookToLibrary(book1);
//        library.showListOfBooks();


//        reader.addToBlackList(reader);
        reader.readerGiveBooks(reader, book1);
//        reader.readerGiveBooks(book1);
//        reader.readerGiveBooks(book1);
//
        reader1.readerGiveBooks(reader1, book2);
//        reader1.readerGiveBooks(book2);
//        reader1.readerGiveBooks(book2);
//
        //library.listOfReaderBooks(reader1);
        //library.listOfBooksOnReaders();
    }
}
