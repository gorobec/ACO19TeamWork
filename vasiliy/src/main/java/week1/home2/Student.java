package week1.home2;

import java.util.Comparator;

public class Student {

    private static final int DEFAULT_COUNT_SUBJECTS = 100;

    private String name;
    private String address;
    private Subject[] subjects;
    private int countSubjects;

    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        this.subjects = new Subject[DEFAULT_COUNT_SUBJECTS];
    }

    public int findSubject(SubjectInfo subjectInfo) {
        if (subjectInfo == null) {
            return -1;
        }
        for (int i = 0; i < countSubjects; i++) {
            if (subjectInfo.equals(subjects[i].getSubjectInfo())) {
                return i;
            }
        }
        return -1;
    }

    public boolean addSubject(SubjectInfo subjectInfo) {
        if (countSubjects == DEFAULT_COUNT_SUBJECTS) {
            return false;
        }
        int subjectIndex = findSubject(subjectInfo);
        if (subjectIndex != -1) {
            return false;
        }
        this.subjects[countSubjects] = new Subject(subjectInfo);
        countSubjects++;
        return true;
    }

    public boolean study(SubjectInfo subjectInfo, int hours) {
        int subjectIndex = findSubject(subjectInfo);
        if (subjectIndex == -1) {
            return false;
        }
        return subjects[subjectIndex].increaseWorkingHours(hours);
    }

    public boolean passExam(SubjectInfo subjectInfo, int mark) {
        int subjectIndex = findSubject(subjectInfo);
        if (subjectIndex == -1) {
            return false;
        }
        return subjects[subjectIndex].setMark(mark);
    }

    public int getMark(SubjectInfo subjectInfo) {
        int subjectIndex = findSubject(subjectInfo);
        if (subjectIndex == -1) {
            return -1;
        }
        return subjects[subjectIndex].getMark();
    }

    public boolean removeLastSubject() {
        if (countSubjects == 0) {
            return false;
        }
        subjects[countSubjects] = null;
        countSubjects--;
        return true;
    }

    public void sort() {
        for (int i = 0; i < countSubjects; i++) {
            for (int j = 0; j < countSubjects - 1; j++) {
                if (subjects[j].compareTo(subjects[j + 1]) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    public void sort(Comparator comparator) {
        for (int i = 0; i < countSubjects; i++) {
            for (int j = 0; j < countSubjects - 1; j++) {
                if (comparator.compare(subjects[j], (subjects[j + 1])) > 0) {
                    swap(j, j + 1);
                }
            }
        }
    }

    private void swap(int j, int i) {
        Subject temp = subjects[i];
        subjects[i] = subjects[j];
        subjects[j] = temp;
    }

    public String getAllSubjects() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < countSubjects; i++) {
            res.append(String.format("%s, working hours: %d, mark: %d \n", subjects[i].getSubjectInfo().asString(),
                    subjects[i].getWorkingHours(), subjects[i].getMark()));
        }
        return res.toString();
    }

    public double getAverageMark() {
        if (countSubjects == 0)
            return 0;
        int countExams = 0;
        int sum = 0;
        for (int i = 0; i < countSubjects; i++) {
            int mark = subjects[i].getMark();
            if (mark != 0) {
                sum += mark;
                countExams++;
            }
        }
        return countExams == 0 ? 0 : (double) sum / countExams;
    }
}