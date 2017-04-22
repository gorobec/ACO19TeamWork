package homeWorkWeek2.task2_5;

/**
 * Created by volodymyrkorniienko on 13.04.17.
 */
public class TestUniver {

    public static void main(String[] args) {

        University university = new University("NAU", 5);
        Group group = new Group("ACO1", 5);
        Group group1 = new Group("ACO2", 5);
        Student student = new Student(21,"Test", "Test", group, university);
        Student student1 = new Student(12,"Test1", "Test1", group, university);

        group.addStudentToGroup(student);
        group.addStudentToGroup(student1);
        group.showAllInformation();
    }
}
