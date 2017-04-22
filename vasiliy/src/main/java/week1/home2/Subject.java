package week1.home2;

public class Subject implements Comparable {
    private SubjectInfo subjectInfo;
    private int workingHours;
    private int mark;

    public Subject(SubjectInfo subjectInfo) {
        this.subjectInfo = subjectInfo;
    }

    public SubjectInfo getSubjectInfo() {
        return subjectInfo;
    }

    public String getSubjectName() {
        return subjectInfo.getName();
    }

    public int getWorkingHours() {
        return workingHours;
    }

    public boolean increaseWorkingHours(int hours) {
        int volume = subjectInfo.getTotalHours();
        if (workingHours + hours > volume) {
            return false;
        }
        workingHours += hours;
        return true;
    }

    public boolean setMark(int mark) {
        if (mark >= 3 && mark <= 5) {
            this.mark = mark;
            return true;
        }
        return false;
    }

    public int getMark() {
        return mark;
    }

    @Override
    public int compareTo(Object o) {
        Subject subject = (Subject) o;
        return this.subjectInfo.getName().compareTo(subject.subjectInfo.getName());
    }
}