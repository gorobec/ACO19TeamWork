package week2.home4;

import org.junit.*;

public class LibraryTest {
    private Edition book1;

    private Reader reader1;
    private Reader reader2;

    private Library library;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("The Hound of the Baskervilles.", 1988, "Conan Doyle", Genre.DETECTIVE, 1);

        reader1 = new Reader("Dmytro", "Peremohu");
        reader2 = new Reader("Alex", "Tolsogo");

        library = new Library();
    }

    @After
    public void tearDown() throws Exception {
        book1 = null;

        reader1 = null;
        reader2 = null;

        library = null;
    }

    @Test
    public void addEdition1() {
        boolean actual = library.addEdition(book1);
        Assert.assertTrue(actual);
    }

    @Test
    public void addEdition2() {
        library.addEdition(book1);
        boolean actual = library.addEdition(book1);
        Assert.assertFalse(actual);
    }

    @Test
    public void addReader1() {
        boolean actual = library.addReader(reader1);
        Assert.assertTrue(actual);
    }

    @Test
    public void addReader2() {
        library.addReader(reader1);
        boolean actual = library.addReader(reader1);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader1() {
        boolean actual = library.giveEditionToReader(null, reader1);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader2() {
        boolean actual = library.giveEditionToReader(book1, reader1);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader3() {
        library.addEdition(book1);
        boolean actual = library.giveEditionToReader(book1, null);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader4() {
        library.addEdition(book1);
        boolean actual = library.giveEditionToReader(book1, reader1);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader5() {
        library.addEdition(book1);
        library.addReader(reader1);
        library.giveEditionToReader(book1, reader1);
        boolean actual = library.giveEditionToReader(book1, reader2);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader6() {
        library.addEdition(book1);
        library.addReader(reader1);
        library.addReaderToBlackList(reader1);
        boolean actual = library.giveEditionToReader(book1, reader1);
        Assert.assertFalse(actual);
    }

    @Test
    public void giveEditionToReader7() {
        library.addEdition(book1);
        library.addReader(reader1);
        boolean actual = library.giveEditionToReader(book1, reader1);
        Assert.assertTrue(actual);
    }

    @Test
    public void addReaderToBlackList1() {
        boolean actual = library.addReaderToBlackList(reader1);
        Assert.assertTrue(actual);
    }

    @Test
    public void addReaderToBlackList2() {
        library.addReaderToBlackList(reader1);
        boolean actual = library.addReaderToBlackList(reader1);
        Assert.assertFalse(actual);
    }

}