package week1.task2.model;

import week1.task2.utils.CommonUtils;

/**
 * Created by SmooZzzie on 06.04.2017.
 */
public class Student {

    private String name;
    private String address;
    private boolean isStudying;
    private double averageMark;

    private Subject[] containerOfSubjects;
    private int lastElementOfSubjects = 0;

    public Student(String name, String address, boolean isStudying, int subjContainerSize) {
        this.name = name;
        this.address = address;
        this.isStudying = isStudying;
        this.containerOfSubjects = new Subject[subjContainerSize];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isStudying() {
        return isStudying;
    }

    public void setStudying(boolean studying) {
        isStudying = studying;
    }

    public Subject[] getContainerOfSubjects() {
        return containerOfSubjects;
    }

    public void setContainerOfSubjects(Subject[] containerOfSubjects) {
        this.containerOfSubjects = containerOfSubjects;
    }

    public double getAverageMark() {

        if (averageMark == 0 && containerOfSubjects == null) {
            return 0;
        } else {
            if (averageMark == 0 && contains()) {
                for (int i = 0; i < lastElementOfSubjects; i++) {
                    averageMark += containerOfSubjects[i].getStudentSubjectMark();
                }
                averageMark /= lastElementOfSubjects;
            }
            return averageMark;
        }
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public int getLastElementOfSubjects() {
        return lastElementOfSubjects;
    }

    public void setLastElementOfSubjects(int lastElementOfSubjects) {
        this.lastElementOfSubjects = lastElementOfSubjects;
    }

    public void toStudy() {

        if (!isStudying) {
            isStudying = true;
        } else {
            System.out.println("Student already studying!");
        }

    }

    public boolean addSubject(Subject newSubject) {

        if (newSubject == null) {
            System.out.println("Please fill in all fields and try again!");
            return false;
        } else {
            if (contains(newSubject)) {
                System.out.println("This subject already existing in this list!");
                return false;
            }
        }

        if (lastElementOfSubjects == containerOfSubjects.length) {
            containerOfSubjects = CommonUtils.extendContainer(containerOfSubjects);
            recordingIntoCell(newSubject);
            return true;
        } else {
            recordingIntoCell(newSubject);
            return true;
        }
    }

    public boolean contains(Subject searchingSubject) {


        for (int i = 0; i < lastElementOfSubjects; i++) {
            if ((containerOfSubjects[i].getName()).equals(searchingSubject.getName())) {
                return true;
            }
        }

        return false;
    }

    public boolean contains() {


        for (int i = 0; i < lastElementOfSubjects; i++) {
            if ((containerOfSubjects[i].getStudentSubjectMark() >= 3)) {
                return true;
            }
        }

        return false;
    }

    private void recordingIntoCell(Subject newSubject) {

        containerOfSubjects[lastElementOfSubjects] = newSubject;
        lastElementOfSubjects++;
    }

    public boolean deleteLastSubject() {

        if (containerOfSubjects == null) {
            return false;
        }

        if (containerOfSubjects[lastElementOfSubjects - 1] != null) {
            containerOfSubjects[lastElementOfSubjects - 1] = null;
            lastElementOfSubjects--;
            return true;
        } else return false;
    }

    public void showAllSubjectsInfo() {

        if (containerOfSubjects == null) {
            System.out.println("This student hasn't any subjects!");
        } else {
            for (int i = 0; i < lastElementOfSubjects; i++) {
                System.out.println(containerOfSubjects[i].getSubjectInfo());
            }
        }
    }

}
