package week2.task5_7Equals_Comparable;

/**
 * Created by SmooZzzie on 26.04.2017.
 */
public class SortTest {

    public static void main(String[] args) {
        Group testGroup = new Group();



        testGroup.setActualGroupSize(8);

        testGroup.getStudents()[0] = new Student("Vova", "Novak");
        testGroup.getStudents()[1] = new Student("Artem","Schepets");
        testGroup.getStudents()[2] = new Student("Vadim","Murashko");
        testGroup.getStudents()[3] = new Student("Anna","Dronova");
        testGroup.getStudents()[4] = new Student("Artem","Dryghalo");
        testGroup.getStudents()[5] = new Student("Inna","Orev");
        testGroup.getStudents()[6] = new Student("Max","Tanana");
        testGroup.getStudents()[7] = new Student("Dima","Vihtyuk");

        testGroup.sort();

        System.out.println(testGroup.toString());

    }
}
