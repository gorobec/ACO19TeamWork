package week2.day2;

import week2.day1.Employee;

import java.util.Comparator;

/**
 * Created by gorobec on 09.04.17.
 */
public class NameComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {

        Employee employee = (Employee) o1;
        Employee employee2 = (Employee) o2;


        return employee.getName().compareTo(employee2.getName());
    }
}
