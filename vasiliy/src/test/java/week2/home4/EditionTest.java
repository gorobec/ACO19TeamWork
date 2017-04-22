package week2.home4;

import org.junit.*;

public class EditionTest {
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
    public void addReader1() {
        boolean actual = mag1.addReader(reader1);
        Assert.assertTrue(actual);
    }

    @Test
    public void addReader2() {
        mag1.addReader(reader1);

        boolean actual = mag1.addReader(reader2);
        Assert.assertTrue(actual);
    }

    @Test
    public void addReader3() {
        book1.addReader(reader1);

        boolean actual = book1.addReader(reader2);
        Assert.assertFalse(actual);
    }

    @Test
    public void isFree1() {
        boolean actual = mag1.isFree();
        Assert.assertTrue(actual);
    }

    @Test
    public void isFree2() {
        mag1.addReader(reader1);

        boolean actual = mag1.isFree();
        Assert.assertTrue(actual);
    }

    @Test
    public void isFree3() {
        mag1.addReader(reader1);
        mag1.addReader(reader2);

        boolean actual = mag1.isFree();
        Assert.assertFalse(actual);
    }

    @Test
    public void compareTo1() {
        boolean actual = mag1.compareTo(book1) > 0;
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo2() {
        boolean actual = book1.compareTo(book2) > 0;
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo3() {
        boolean actual = mag1.compareTo(book2) > 0;
        Assert.assertTrue(actual);
    }

    @Test
    public void compareTo4() {
        boolean actual = mag2.compareTo(new Magazine("Iteration", 1990, Periodicity.MONTHLY, 5)) == 0;
        Assert.assertTrue(actual);
    }

}