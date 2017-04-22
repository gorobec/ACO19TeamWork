package week2.home4;

import org.junit.*;

public class ReaderTest {
    private Edition book1;
    private Edition book2;
    private Edition mag1;
    private Edition mag2;
    private Reader reader1;
    private Reader reader2;

    @Before
    public void setUp() throws Exception {
        book1 = new Book("Evgeniy Onegin", 1985, "Pushkin", Genre.POETRY, 1);
        book2 = new Book("Eneida", 1988, "Kotlyarevskiy", Genre.POETRY, 1);
        mag1 = new Magazine("Soccer", 1988, Periodicity.MONTHLY, 2);
        mag2 = new Magazine("Iteration", 1998, Periodicity.WEEKLY, 3);

        reader1 = new Reader("Dmytro", "Peremohu");
        reader2 = new Reader("Alex", "Tolsogo");
    }

    @After
    public void tearDown() throws Exception {
        book1 = null;
        book2 = null;
        mag1 = null;
        mag2 = null;
        reader1 = null;
        reader2 = null;
    }

    @Test
    public void addEdition1() {
        reader1.addEdition(book1);

        boolean actual = reader1.addEdition(book1);
        Assert.assertFalse(actual);
    }

    @Test
    public void addEdition2() {
        reader1.addEdition(book1);
        reader1.addEdition(book2);
        reader1.addEdition(mag1);

        boolean actual = reader1.addEdition(mag2);
        Assert.assertFalse(actual);
    }

    @Test
    public void addEdition3() {
        reader1.addEdition(book1);
        reader1.addEdition(mag1);

        boolean actual = reader1.addEdition(book2);
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo1() {
        boolean actual = reader1.compareTo(reader2) > 0;
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo2() {
        boolean actual = reader2.compareTo(reader1) < 0;
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo3() {
        boolean actual = reader1.compareTo(reader1) == 0;
        Assert.assertTrue(actual);
    }
}