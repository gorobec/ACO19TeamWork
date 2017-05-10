package week2.task5_7Equals_Comparable;

/**
 * Created by SmooZzzie on 10.05.2017.
 */
public class UniversityCloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        University testUniver = new University("test", 2);

        Group testGroup1 = new Group("test", 5);
        Group testGroup2 = new Group("test2", 4);

        Student testStudent1 = new Student("testName11", "testSurname11");
        Student testStudent2 = new Student("testName12", "testSurname12");
        Student testStudent3 = new Student("testName13", "testSurname13");
        Student testStudent4 = new Student("testName14", "testSurname14");
        Student testStudent5 = new Student("testName15", "testSurname15");
        Student testStudent6 = new Student("testName21", "testSurname21");
        Student testStudent7 = new Student("testName22", "testSurname22");
        Student testStudent8 = new Student("testName23", "testSurname23");
        Student testStudent9 = new Student("testName24", "testSurname24");

        testGroup1.getStudents()[0] = testStudent1;
        testGroup1.getStudents()[1] = testStudent2;
        testGroup1.getStudents()[2] = testStudent3;
        testGroup1.getStudents()[3] = testStudent4;
        testGroup1.getStudents()[4] = testStudent5;

        testGroup2.getStudents()[0] = testStudent6;
        testGroup2.getStudents()[1] = testStudent7;
        testGroup2.getStudents()[2] = testStudent8;
        testGroup2.getStudents()[3] = testStudent9;

        testUniver.getListOfGroups()[0] = testGroup1;
        testUniver.getListOfGroups()[1] = testGroup2;

        University clone = testUniver.clone();

        Student newTestStudent1 = new Student("Artem", "Shchepets");
        Student newTestStudent2 = new Student("Vova", "Novak");

        clone.getListOfGroups()[0].getStudents()[0] = newTestStudent1;
        clone.getListOfGroups()[1].getStudents()[0] = newTestStudent2;
        clone.setUniversityName("KPI");

        System.out.println("*******ORIGINAL OBJECT*******");
        System.out.println(testUniver);
        System.out.println("*******CLONED OBJECT********");
        System.out.println(clone);
    }
}
