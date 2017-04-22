package week2.home4;

import java.util.*;

public class Reader implements Comparable<Reader> {
    private static final int EDITIONS_COUNT = 3;

    private String name;
    private String address;
    private List<Edition> editions = new ArrayList<>(EDITIONS_COUNT);
    private Comparator<Edition> editionComparator;
    private boolean isInBlackList;

    public Reader(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public boolean getIsInBlackList() {
        return isInBlackList;
    }

    public void setIsInBlackList(boolean isInBlackList) {
        this.isInBlackList = isInBlackList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reader reader = (Reader) o;

        if (name != null ? !name.equals(reader.name) : reader.name != null) return false;
        return address != null ? address.equals(reader.address) : reader.address == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public void setEditionComparator(Comparator<Edition> editionComparator) {
        this.editionComparator = editionComparator;
    }

    public boolean addEdition(Edition edition) {
        if (editions.size() < EDITIONS_COUNT && !editions.contains(edition)) {
            if (!editions.add(edition)) {
                return false;
            }
            if (!edition.addReader(this)) {
                editions.remove(edition);
                return false;
            }
            return true;
        }
        return false;
    }

    public void showEditions() {
        if (editions.isEmpty()) {
            System.out.println("This reader " + name + " has no editions");
            return;
        }
        editions.sort(editionComparator);
        System.out.println("List of the editions of the reader " + name);
        for (Edition edition : editions) {
            System.out.println(edition);
        }
    }

    @Override
    public int compareTo(Reader reader) {
        return this.name.compareTo(reader.name);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
