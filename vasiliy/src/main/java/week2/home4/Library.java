package week2.home4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Library {
    private static final int EDITIONS_COUNT = 1000;
    private static final int READERS_COUNT = 1000;

    private List<Edition> editions = new ArrayList<>(EDITIONS_COUNT);
    private List<Reader> readers = new ArrayList<>(READERS_COUNT);

    private Comparator<Edition> editionComparator;
    private Comparator<Reader> readerComparator;

    public void setEditionComparator(Comparator<Edition> editionComparator) {
        this.editionComparator = editionComparator;
    }

    public void setReaderComparator(Comparator<Reader> readerComparator) {
        this.readerComparator = readerComparator;
    }

    public boolean addEdition(Edition edition) {
        return !editions.contains(edition) && editions.add(edition);
    }

    public boolean addReader(Reader reader) {
        return !readers.contains(reader) && readers.add(reader);
    }

    public void showFreeEditions() {
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        List<Edition> freeList = new ArrayList<>();
        for (Edition edition : editions) {
            if (edition.isFree()) {
                freeList.add(edition);
            }
        }
        if (freeList.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("List of the free editions");
        freeList.sort(editionComparator);
        for (Edition edition : freeList) {
            System.out.println(edition);
        }
    }

    public void showAllReaders() {
        if (readers.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("List of the readers");
        readers.sort(readerComparator);
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }

    public boolean giveEditionToReader(Edition edition, Reader reader) {
        if (edition == null || !editions.contains(edition)) {
            return false;
        }
        if (reader == null || !readers.contains(reader)) {
            return false;
        }
        int editionIdx = editions.indexOf(edition);
        int readerIdx = readers.indexOf(reader);
        Reader rdr = readers.get(readerIdx);
        Edition ed = editions.get(editionIdx);
        if (!ed.isFree() || rdr.getIsInBlackList()) {
            return false;
        }
        return rdr.addEdition(ed);
    }

    public boolean addReaderToBlackList(Reader reader) {
        if (reader.getIsInBlackList()) {
            return false;
        }
        reader.setIsInBlackList(true);
        return true;
    }

    public void showBookByAuthor(String author) {
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        List<Edition> authorList = new ArrayList<>();
        for (Edition edition : editions) {
            if (edition.getClass() == Book.class) {
                Book book = (Book) edition;
                if (book.getAuthor().equals(author))
                    authorList.add(edition);
            }
        }
        if (authorList.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("Editions of the " + author);
        authorList.sort(editionComparator);
        for (Edition edition : authorList) {
            System.out.println(edition);
        }
    }

    public void showBookByGenre(Genre genre) {
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        List<Edition> genreList = new ArrayList<>();
        for (Edition edition : editions) {
            if (edition.getClass() == Book.class) {
                Book book = (Book) edition;
                if (book.getGenre() == genre)
                    genreList.add(edition);
            }
        }
        if (genreList.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("Editions of the genre " + genre);
        genreList.sort(editionComparator);
        for (Edition edition : genreList) {
            System.out.println(edition);
        }
    }

    public void showEditionByYear(int year) {
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        List<Edition> yearList = new ArrayList<>();
        for (Edition edition : editions) {
            if (edition.getYear() == year) {
                yearList.add(edition);
            }
        }
        if (yearList.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("Editions of the year " + year);
        yearList.sort(editionComparator);
        for (Edition edition : yearList) {
            System.out.println(edition);
        }
    }

    public void findEditionByTitle(String keyWord) {
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        List<Edition> titleList = new ArrayList<>();
        for (Edition edition : editions) {
            if (edition.getTitle().contains(keyWord)) {
                titleList.add(edition);
            }
        }
        if (editions.isEmpty()) {
            showMessageAboutEmptyList();
            return;
        }
        System.out.println("Editions with title containing key word: " + keyWord);
        titleList.sort(editionComparator);
        for (Edition edition : titleList) {
            System.out.println(edition);
        }
    }

    private void showMessageAboutEmptyList() {
        System.out.println("There is no such information");
    }
}
