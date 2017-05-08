package week1.task2.model;

import java.util.Random;

/**
 * Created by SmooZzzie on 06.04.2017.
 */
public class Subject {

    private static final int MIN_RANGE_OF_MARK = 3;

    private String name;
    private int subjectHours;
    private int studentActualHours;
    private int studentSubjectMark;

    public Subject(String name, int subjectHours, int studentActualHours) {
        this.name = name;
        this.subjectHours = subjectHours;
        this.studentActualHours = studentActualHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubjectHours() {
        return subjectHours;
    }

    public void setSubjectHours(int subjectHours) {
        this.subjectHours = subjectHours;
    }

    public int getStudentActualHours() {
        return studentActualHours;
    }

    public void setStudentActualHours(int studentActualHours) {
        this.studentActualHours = studentActualHours;
    }

    public int getStudentSubjectMark() {

        return studentSubjectMark;
    }

    public String getStudentSubjectMarkInfo() {

        if (studentSubjectMark == 0) {
            return "Not Examined";
        }

        String studentMark = "" + (char) studentSubjectMark;

        return studentMark;
    }


    public void setStudentSubjectMark(int studentSubjectMark) {
        this.studentSubjectMark = studentSubjectMark;
    }

    public String getSubjectInfo() {
        return String.format("Name of subject: %s\t| Subject hours: %d\t| Student's working hours: %d\t|" +
                " Student's mark: %s", name, getSubjectHours(), getStudentActualHours(), getStudentSubjectMarkInfo());
    }

    public boolean examineStudent() {
        Random random = new Random();

        if (studentSubjectMark != 0) {
            System.out.println("Student has been already examined!");
            return false;
        } else {
            studentSubjectMark = random.nextInt(MIN_RANGE_OF_MARK) + MIN_RANGE_OF_MARK;
            return true;
        }
    }


}
