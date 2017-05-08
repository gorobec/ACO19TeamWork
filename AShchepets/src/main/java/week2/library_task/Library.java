package week2.library_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by SmooZzzie on 27.04.2017.
 */
public class Library {

    private static final int MAX_QUANTITY_OF_READERS = 1000;
    private static final int MAX_QUANTITY_OF_EDITIONS = 10000;

    private List<Reader> readersList = new ArrayList<>(MAX_QUANTITY_OF_READERS);
    private List<Edition> editionsList = new ArrayList<>(MAX_QUANTITY_OF_EDITIONS);

    boolean containsSimilar = false; // supporting variable,
    // using in showEditionsByAuthor() and ShowEditionsByYear()


    public List<Reader> getReadersList() {
        return readersList;
    }

    public List<Edition> getEditionsList() {
        return editionsList;
    }

    public void showReaders() {

        if (readersList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        System.out.println("***Library's readers***");

        for (int i = 0; i < readersList.size(); i++) {
            System.out.println(readersList.get(i).toString());
        }
    }

    private void messageAboutEmptiness() {
        System.out.println("The list is empty!");
    }

    public void showAvailableEditions() {

        if (editionsList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        System.out.println("***All Available Editions***");

        for (int i = 0; i < editionsList.size(); i++) {
            if (editionsList.get(i).getQuantity() > 0)
                System.out.println(editionsList.get(i).toString());
        }
    }


    public boolean addReader(Reader newReader) {

        if (newReader == null || readersList.contains(newReader)) return false;

            readersList.add(newReader);
            Collections.sort(readersList);
            return true;

    }

    public boolean addEdition(Edition newEdition) {
        if (newEdition == null || editionsList.contains(newEdition)) return false;

            editionsList.add(newEdition);
            Collections.sort(editionsList);
            return true;

    }

    public boolean addEditionToReader(Edition edition, Reader reader) {

        if (reader == null || !readersList.contains(reader)) return false;

        if (edition == null || !editionsList.contains(edition)) return false;

        Reader readerInList = readersList.get(readersList.indexOf(reader));
        Edition editionInList = editionsList.get(editionsList.indexOf(edition));

        return readerInList.addEdition(editionInList);
    }

    public void showReadersEditions() {

        if (readersList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        System.out.println("***Readers' editions***");
        for (int i = 0; i < readersList.size(); i++) {

            System.out.println(readersList.get(i).getName() + " " + readersList.get(i).getSurname() + " :");
            if (readersList.get(i).getReaderEditions().isEmpty()) {
                System.out.println("\t Reader hasn't any books!");
                continue;
            }
            for (int j = 0; j < readersList.get(i).getReaderEditions().size(); j++) {
                System.out.println("\t" + readersList.get(i).getReaderEditions().get(j).toString());
            }
        }
    }

    public void showCertainReaderEditions(Reader reader) {

        if (readersList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        if (reader == null || !readersList.contains(reader)) {
            System.out.println("Reader is null or isn't a member of the library! Try again!");
            return;
        }

        Reader readerInList = readersList.get(readersList.indexOf(reader));

        System.out.println("\n***" + readerInList.getName() + " " + readerInList.getSurname() + "'s editions*** ");

        if (readerInList.getReaderEditions().isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        for (int i = 0; i < readerInList.getReaderEditions().size(); i++) {
            System.out.println("\t" + readerInList.getReaderEditions().get(i).toString());
        }
    }

    public boolean addReaderToTheBlackList(Reader reader) {

        if (readersList.isEmpty() || !readersList.contains(reader) || reader.isBanned())
            return false;

        reader.setBanned(true);
        return true;
    }

    // в задании указано вывести издания с конкретным автором. У журналов(и т.д.) нету определенного автора,
    // над ними работают много человек из издательства. Поэтому логично,
    // что в данном методе будут проверяться только книжки, а периодическая литература будет игнорироваться.

    public void showEditionsByAuthor(String author) {

        if (editionsList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        containsSimilar = false;
        System.out.println("\nAll library's books written by " + author + ":");
        for (int i = 0; i < editionsList.size(); i++) {
            if (editionsList.get(i).getClass() == Book.class) {

                Book book = (Book) editionsList.get(i);

                if (book.getAuthor().equals(author)) {

                    Edition edition = (Edition) book;
                    System.out.println(edition.toString());

                    containsSimilar = true;
                }
            }
        }

        if (containsSimilar == false)
            System.out.println("There aren't any books written by this author!");

    }

    public void showEditionsByYear(int year) {

        if (editionsList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        if (year < 1500 && year > 2017) {
            System.out.println("Wrong input of the publishing year!");
        }

        containsSimilar = false;

        System.out.println("\nAll library's editions written/published in " + year + ":");
        for (int i = 0; i < editionsList.size(); i++) {
            if (editionsList.get(i).getYearOfPublishing() == year) {

                System.out.println(editionsList.get(i).toString());

                containsSimilar = true;
            }

        }

        if (containsSimilar == false)
            System.out.println("There aren't any books written in that year!");

    }

    public void findEditionByName(String keyWord) {

        if (editionsList.isEmpty()) {
            messageAboutEmptiness();
            return;
        }

        if (keyWord == null) {
            System.out.println("The keyword is null! We cannot find anything!");
        }

        containsSimilar = false;

        System.out.println("\nResult of searching by " + keyWord + ": ");
        for (int i = 0; i < editionsList.size(); i++) {
            if (editionsList.get(i).getEditionName().contains(keyWord)) {

                System.out.println(editionsList.get(i).toString());

                containsSimilar = true;
            }

        }

        if (containsSimilar == false) {
            System.out.println("Nothing was found!");
        }

    }

}
