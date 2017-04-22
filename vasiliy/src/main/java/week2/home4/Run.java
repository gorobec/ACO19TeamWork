package week2.home4;

public class Run {
    public static void main(String[] args) {
        Edition book1 = new Book("The Hound of the Baskervilles.", 1988, "Conan Doyle", Genre.DETECTIVE, 1);
        Edition book2 = new Book("The Sign of the Four", 1985, "Conan Doyle", Genre.DETECTIVE, 2);
        Edition book3 = new Book("Voyna i mir", 1988, "Lev Tolstoy", Genre.NOVEL, 1);
        Edition book4 = new Book("Anna Karenina", 1985, "Lev Tolstoy", Genre.NOVEL, 2);
        Edition book5 = new Book("Evgeniy Onegin", 1985, "Pushkin", Genre.POETRY, 1);
        Edition book6 = new Book("Eneida", 1988, "Kotlyarevskiy", Genre.POETRY, 1);
        Edition mag1 = new Magazine("Soccer", 1988, Periodicity.MONTHLY, 2);
        Edition mag2 = new Magazine("Iteration", 1998, Periodicity.WEEKLY, 3);
        Edition mag3 = new Magazine("Team", 1985, Periodicity.WEEKLY, 4);

        Reader reader1 = new Reader("Dmytro", "Peremohu");
        Reader reader2 = new Reader("Alex", "Tolsogo");
        Reader reader3 = new Reader("Ivan", "Saksaganskogo");

        Library library = new Library();
        library.addEdition(book1);
        library.addEdition(book2);
        library.addEdition(book3);
        library.addEdition(book4);
        library.addEdition(book5);
        library.addEdition(book6);
        library.addEdition(mag1);
        System.out.println(library.addEdition(book1));
        library.addEdition(mag2);
        library.addEdition(mag3);

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);

        library.showAllReaders();
        library.setReaderComparator(new AddressComparator());
        library.showAllReaders();

        library.setEditionComparator(new YearComparator());
        library.showFreeEditions();

        library.giveEditionToReader(book2, reader1);
        System.out.println(library.giveEditionToReader(book2, reader2));
        System.out.println(library.giveEditionToReader(book2, reader3));
        System.out.println(book2.info());

        library.giveEditionToReader(book6, reader1);
        library.giveEditionToReader(mag1, reader2);
        library.giveEditionToReader(book3, reader3);
        library.addReaderToBlackList(reader3);
        System.out.println(library.giveEditionToReader(mag3, reader3));

        library.showFreeEditions();

        reader1.showEditions();
        reader1.setEditionComparator(new YearComparator());
        reader1.showEditions();

        library.showBookByAuthor("Lev Tolstoy");

        library.showEditionByYear(1985);
        library.showEditionByYear(2000);

        library.findEditionByTitle("e ");

        library.showBookByGenre(Genre.POETRY);
        library.showBookByGenre(Genre.FANTASY);
    }
}
