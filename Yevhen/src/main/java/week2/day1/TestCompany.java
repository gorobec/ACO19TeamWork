package week2.day1;

import week2.day2.AgeComparator;
import week2.day2.NameComparator;

import java.util.Comparator;

/**
 * Created by gorobec on 08.04.17.
 */
public class TestCompany {
    public static void main(String[] args) {
        Employee employee = new Junior("Ann", "Smith", 25, "Java");
        Employee junior = new Junior("Ann", "Smith", 15, "Java");
        Employee middle = new Middle("Dan", "Smith", 35, "Java");
        Employee senior = new Senior("David", "Smith", 5, "Java");



        Manager manager = new Manager("David", "Smith", 45, 6);
        System.out.println(manager.toString());

        System.out.println("Adding ...");
        manager.addEmployee(employee);
        manager.addEmployee(junior);
        manager.addEmployee(middle);
        manager.addEmployee(senior);

//        Comparator comparator = new AgeComparator();
//        Comparator comparator = new NameComparator();

//        manager.showEmployeeByParameters(new AgeComparator());
        manager.showEmployeeByParameters((o1, o2) -> {
            Employee employee1 = (Employee) o1;
            Employee employee2 = (Employee) o2;
            return Integer.compare(employee1.getAge(), employee2.getAge());
        } );
        System.out.println(manager.toString());


        /*Employee find = manager.find(junior);
//        if(find instanceof Coder){
        if(find.getClass() == Junior.class){
            Junior jun = (Junior) find;
            jun.code();
        }*/

        manager.work();

        manager.getEmployees()[1].setName("Jim");

        System.out.println(junior);

    }
}
