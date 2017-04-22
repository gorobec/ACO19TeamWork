package week1.home2;

import java.util.ArrayList;

public class SubjectInfo {
    private String name;
    private int totalHours;
    public static ArrayList<SubjectInfo> subjectInformation = new ArrayList<SubjectInfo>();

    public SubjectInfo(String name, int totalHours) {
        this.name = name;
        this.totalHours = totalHours;
        subjectInformation.add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (this == o) {
            return true;
        }

        SubjectInfo subjectInfo = (SubjectInfo) o;

        return name.equals(subjectInfo.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public static void printSubjectInformation() {
        for (SubjectInfo subjectInfo : subjectInformation) {
            System.out.println(subjectInfo.asString());
        }
    }

    public String asString() {
        return String.format("Subject name: %s, subject totalHours: %d", name, totalHours);
    }

    public String getName() {
        return name;
    }

    public int getTotalHours() {
        return totalHours;
    }
}