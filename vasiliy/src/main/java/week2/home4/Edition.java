package week2.home4;

import java.util.ArrayList;
import java.util.List;

public abstract class Edition implements Comparable<Edition> {
    private String title;
    private int year;
    private List<Reader> readers;
    private final int count;

    public Edition(String title, int year, int count) {
        this.title = title;
        this.year = year;
        this.count = count;
        readers = new ArrayList<>(count);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public boolean addReader(Reader reader) {
        return this.isFree() && readers.add(reader);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edition edition = (Edition) o;

        if (year != edition.year) return false;
        return title != null ? title.equals(edition.title) : edition.title == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + year;
        return result;
    }

    public boolean isFree() {
        return readers.size() < count;
    }

    public final String info() {
        StringBuilder readersInfo = new StringBuilder();
        if (!readers.isEmpty()) {
            for (Reader reader : readers) {
                readersInfo.append(reader);
            }
        }
        return this.toString() + "\nList of the readers: " + readersInfo.toString();
    }

    @Override
    public String toString() {
        return "title='" + title + '\'' + ", year=" + year + ", count=" + count;
    }

    @Override
    public int compareTo(Edition edition) {
        return this.getTitle().compareTo(edition.getTitle());
    }
}
