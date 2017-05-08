package week2.library_task;

/**
 * Created by SmooZzzie on 28.04.2017.
 */
public class ShowMethodsTest {

    public static void main(String[] args) {

        Library library = new Library();

        Edition edition1 = new Book("Book1", 1990,"Author1",BookGenre.SCIENCE_FICTION);
        Edition edition2 = new Periodical("Periodical1", 1999,3,PeriodicalType.COMICS, Periodicity.MONTHLY);
        Edition edition3 = new Book("Book2", 2002, 1,"Author2",BookGenre.RELIGIOUS);
        Edition edition4 = new Periodical("Periodical2", 1900, PeriodicalType.NEWSPAPER, Periodicity.DAILY);
        Edition edition5 = new Book("Book3", 2016, "Qwauthor3", BookGenre.ENCYCLOPEDIA);
        Edition edition6 = new Book("Webook3", 2015, "Awauthor3", BookGenre.ENCYCLOPEDIA);
        Edition edition7 = new Book("Webook3", 2016, "Gwauthor3", BookGenre.ENCYCLOPEDIA);
        Edition edition8 = new Book("Boweok3", 2016, "Qwauthor3", BookGenre.ENCYCLOPEDIA);
        Edition edition9 = new Book("Bweook3", 2002, "Aut5", BookGenre.ENCYCLOPEDIA);
        Edition edition10 = new Book("Boowek3", 1990, "Qwau", BookGenre.ENCYCLOPEDIA);
        Edition edition11 = new Book("TESTNAME",0000,"TESTNAME",BookGenre.ENCYCLOPEDIA);
        Edition edition12 = new Periodical("TESTNAME",1243,PeriodicalType.COMICS,Periodicity.DAILY);

        Reader reader1 = new Reader("TESTNAME","TESTSURNAME");
        Reader reader2 = new Reader("Reaaader3", "Surrea");
        Reader reader3 = new Reader("Rwweader1", "Surreader1");
        Reader reader4 = new Reader("Readdfer2", "Surreader2");
        Reader reader5 = new Reader("Reaaader3", "Surreader3");
        Reader reader6 = new Reader("Areader4", "Surreader4", true);

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);
        library.addReader(reader4);
        library.addReader(reader5);
        library.addReader(reader6);

        library.addEdition(edition12);
        library.addEdition(edition11);
        library.addEdition(edition10);
        library.addEdition(edition9);
        library.addEdition(edition8);
        library.addEdition(edition7);
        library.addEdition(edition6);
        library.addEdition(edition5);
        library.addEdition(edition4);
        library.addEdition(edition3);
        library.addEdition(edition2);
        library.addEdition(edition1);


        library.addEditionToReader(edition5,reader2);
        library.addEditionToReader(edition5,reader6);
        library.addEditionToReader(edition3,reader3);
        library.addEditionToReader(edition1,reader2);
        library.addEditionToReader(edition4,reader2);
        library.addEditionToReader(edition11,reader4);
        library.addEditionToReader(edition9,reader4);
        library.addEditionToReader(edition8,reader4);
        library.addEditionToReader(edition5,reader1);
        library.addEditionToReader(edition2,reader3);

        System.out.println();
        library.showReaders();

        System.out.println();
        library.showAvailableEditions();

        System.out.println();
        library.showReadersEditions();
        library.showCertainReaderEditions(reader4);
        library.showEditionsByAuthor("Qwauthor3");
        library.showEditionsByYear(2016);
        library.findEditionByName("we");
    }
}
