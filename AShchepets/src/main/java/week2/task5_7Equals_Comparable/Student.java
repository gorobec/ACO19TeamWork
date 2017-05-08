package week2.task5_7Equals_Comparable;

/**
 * Created by SmooZzzie on 24.04.2017.
 */
public class Student implements Comparable<Student> {

    private String studentName;
    private String studentSurname;

    public Student() {
        this.studentName = "testName";
        this.studentSurname = "testSurname";
    }

    public Student(String studentName, String studentSurname) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || obj.getClass() != Student.class) {
            return false;
        }

        Student other = (Student) obj;

        if (studentName.equals(other.studentName) && studentSurname.equals(other.studentSurname)) {
            return true;
        }

        return false;

    }

    @Override
    public int compareTo(Student nextSt) {

        int nameComparing = studentName.compareTo(nextSt.studentName);


        if (nameComparing == 0) {
            return studentSurname.compareTo(nextSt.studentSurname);
        } else {
            return nameComparing;
        }
    }

    @Override
    public String toString() {
        return "Student " +
                studentName + " " +
                studentSurname;
    }
}
