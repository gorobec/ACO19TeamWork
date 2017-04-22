package homeWorkWeek2.task2_5;

/**
 * Created by volodymyrkorniienko on 12.04.17.
 */
public class Student implements Comparable<Student> {

    private int studentID;
    private String studentName;
    private String studentSurname;
    private Group group;
    private University nameUniversity;

    public Student(int studentID, String studentName, String studentSurname, Group group, University nameUniversity) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        this.group = group;
        this.nameUniversity = nameUniversity;
    }

    public int getStudentID() { return studentID; }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    @Override
    public boolean equals(Object s) {
        if (this == s) return true;

        if (s == null || getClass() != s.getClass()) return false;

        Student student = (Student) s;

        if (student.studentID == this.studentID) return  false;

        if (student.studentID != this.studentID) return true;

        if (student.studentName.equals(this.studentName) &&
                student.studentSurname.equals(this.studentSurname)) return false;

        if (student.studentName.equals(this.studentName) &&
                !student.studentSurname.equals(this.studentSurname)) return true;

        if (!student.studentName.equals(this.studentName) &&
                student.studentSurname.equals(this.studentSurname)) return true;

        if (!student.studentName.equals(this.studentName) &&
                !student.studentSurname.equals(this.studentSurname)) return true;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentName != null ? studentName.hashCode() : 0;
        result = 31 * result + (studentSurname != null ? studentSurname.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Student student) {
        return (this.studentID - student.studentID);
    }
}
