package week2.interfaces.booksInterfaces;

/**
 * Created by SmooZzzie on 22.04.2017.
 */
public class Encyclopedia extends Book implements Edition{

    private int quantityOfBooks;
    private String editionName;
    private int yearOfTHeEdition;

    public Encyclopedia(String name, int quantityOfPages, String typeOfBook, int lastReadPage,
                        int quantityOfBooks, String editionName, int yearOfTHeEdition) {

        super(name, quantityOfPages, typeOfBook, lastReadPage);
        this.quantityOfBooks = quantityOfBooks;
        this.editionName = editionName;
        this.yearOfTHeEdition = yearOfTHeEdition;
    }

    public int getQuantityOfBooks() {
        return quantityOfBooks;
    }

    // overrode methods from Edition Class
    @Override
    public String getNameOfTheEdition() {
        return this.editionName;
    }

    @Override
    public int getYearOfTheEdition() {
        return this.yearOfTHeEdition;
    }

    // overrode method from Book Class
    @Override
    public boolean buy() {

        if (quantityOfBooks > 0) {
            quantityOfBooks--;
            return true;
        }

        return false;
    }



}
