package homeWorkWeek2.task2_5;

/**
 * Created by volodymyrkorniienko on 12.04.17.
 */
public class Group {

    private String groupNumber;
    private Student[] students;

    public Group(String groupNumber, int countOfStudents) {
        this.groupNumber = groupNumber;
        this.students = new Student[countOfStudents];
    }

    public boolean addStudentToGroup(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null || ((students[i].getStudentName().equals(student.getStudentName()))
                    && students[i].getStudentSurname().equals(student.getStudentSurname()))) {
                students[i] = student;
                return true;
            }
        }
        return false;
    }


    public boolean showAllInformation() {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) return false;
            System.out.println(students[i].getStudentID() + " " + students[i].getStudentName()
                    + " " + students[i].getStudentSurname());
        }
        //Arrays.sort();
        return true;
    }


    public String getGroupNumber() {
        return groupNumber;
    }

    @Override
    public boolean equals(Object g) {
        if (this == g) return true;

        if (g == null || getClass() != g.getClass()) return false;

        Group group = (Group) g;

        return group.groupNumber.equals(this.groupNumber);
    }

    @Override
    public int hashCode() {
        return groupNumber != null ? groupNumber.hashCode() : 0;
    }
}
