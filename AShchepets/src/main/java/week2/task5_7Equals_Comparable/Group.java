package week2.task5_7Equals_Comparable;

/**
 * Created by SmooZzzie on 24.04.2017.
 */
public class Group implements Cloneable{

    private static final int DEFAULT_GROUP_SIZE = 20;

    private String groupName;
    private Student[] students;
    private int actualGroupSize;
    private boolean checkAreSame;

    public Group() {
        this.groupName = "TestGroupName";
        this.students = new Student[DEFAULT_GROUP_SIZE];
    }

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new Student[DEFAULT_GROUP_SIZE];
    }

    public Group(String groupName, int sizeOfGroup) {
        this.groupName = groupName;
        this.students = new Student[sizeOfGroup];
    }

    public int getActualGroupSize() {
        return actualGroupSize;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setActualGroupSize(int actualGroupSize) {
        this.actualGroupSize = actualGroupSize;
    }

    public boolean addStudent(Student newStudent) {

        if (newStudent == null || contains(newStudent) || actualGroupSize >= students.length) {
            return false;
        }


        students[actualGroupSize++] = newStudent;
        return true;
    }

    private boolean contains(Student newStudent) {

        for (int i = 0; i < actualGroupSize; i++) {
            if (students[i].equals(newStudent)) {
                return true;
            }
        }

        return false;
    }

    public void sort() {
        for (int i = 0; i < actualGroupSize; i++) {
            for (int j = 0; j < actualGroupSize - 1; j++) {
                if (students[j].compareTo(students[j+1]) > 0) {
                    swap(j,j+1);
                }
            }
        }
    }

    private void swap(int j, int i) {

        Student temp = students[j];

        students[j] = students[i];
        students[i] = temp;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != Group.class) {
            return false;
        }

        Group other = (Group) obj;

        if (actualGroupSize != other.actualGroupSize) {
            return false;
        }

        for (int i = 0; i < actualGroupSize; i++) {
            checkAreSame = false;

            for (int j = 0; j < actualGroupSize; j++) {
                if (students[i].equals(other.students[j])) {
                    checkAreSame = true;
                }
            }
            if (checkAreSame) {
                continue;
            }
            return false;
        }

        return true;
    }

    @Override
    public String toString() {

        String result = "";

        for (int i = 0; i < actualGroupSize; i++) {
            result+=students[i].toString() + "\n";
        }

        return result;
    }

    //added for Week4 CloneTask
    public Group cloneGroup(Group group) throws CloneNotSupportedException {

        Group clone = (Group) super.clone();

        clone.students = cloneListOfStudents();

        return clone;
    }

    private Student[] cloneListOfStudents() throws CloneNotSupportedException {

        Student[] clone = this.students.clone();

        for (int i = 0; i < students.length; i++) {
            clone[i] = clone[i].cloneStudent(clone[i]);
        }
        return clone;
    }
}